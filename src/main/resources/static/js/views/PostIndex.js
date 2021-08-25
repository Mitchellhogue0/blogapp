import createView from "../createView.js";

export default function PostIndex(props) {
    return `
         <header>
            <h1>Posts Page</h1>
        </header>
        <main>
            <!--        CREATE FORM         -->
            <div class="post">
                <form>
                    <div>
                        <span>Post Title: </span>
                    </div>
                    <input class="create-input" id="create-post-title" type="text">
                    <div>
                        <span>Post Content: </span>
                    </div>
                    <input class="create-input" id="create-post-content" type="text">
                    <div>
                        <span>Post Category Tags: </span>
                    </div>
                    <input class="create-input" id="create-post-cat" type="text">
                    <br>
                    <button id="create-btn">Submit</button>
                </form>
            </div>
            <div class="post-container">
                ${getPostsHtml(props.posts)}
            </div>
        </main>
    `;
}


function getPostsHtml (posts) {
    return posts.map(post =>
        `
            <div class="post-object">
                <label for="edit-title"></label>
                <input type="text" class="edit-title" value="${post.title}" readonly>
                <br>
                <label for="edit-content"></label>
                <input type="text" class="edit-content" value="${post.content}" readonly>
                <div class="categories" >
                ${getPostCategoriesComponents(post.categories)}
                </div>
                <p>Posted by: ${post.user.username}</p>
                <button data-id="${post.id}" class="edit-btn">Edit</button>
                <button data-id="${post.id}" class="delete-btn">Delete</button>
                <br>
            </div>
            `).join('')
}


function getPostCategoriesComponents (categories) {

    return categories.map(category => {
        `
        <span>#${category.name}</span>
        `
    })
}


export function PostsEvent() {
    createEvent();
    editEvent();
    deleteEvent();
}


function createEvent() {
    //TODO: add event listeners for create/edit/delete, get data, send fetch
    $("#create-btn").click(function () {
        let post = {
            title: $("#create-post-title").val(),
            content: $("#create-post-content").val()
        };
        console.log(post)

        let request = {
            method: "POST",
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(post)
        }

        fetch("http://localhost:8080/api/posts", request)
            .then(res => {
                console.log(res.status)
                createView("/posts")
            }).catch(error => {
            console.log(error);
            createView("/posts");
        });
    });
}


function editEvent() {
    $(".edit-btn").click(function () {
        console.log("edit event fired off");
        $(".edit-btn").text("Edit");
        $(".edit-title, .edit-content").attr("readonly", true);
        $(this).siblings(".edit-title, .edit-content").attr("readonly", false);
        $(this).text("Save");

        $(this).on("click", submitEditEvent)
    })
}


function submitEditEvent() {
    let post = {
        title: $(this).siblings("edit-title").text(),
        content: $(this).siblings("edit-content").text()
    }
    let request = {
        method: "PUT",
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(post)
    }
    $(this).off("click", submitEditEvent)

    let id = $(".edit-btn").attr("data-id")

    fetch(`http://localhost:8080/api/posts/${id}`, request)
        .then(res => {
            console.log(res.status)
            createView("/posts")
        }).catch(error => {
        console.log(error);
        createView("/posts");
    });
}


function deleteEvent(){
    $(".delete-btn").click(function (){

        let request = {
            method: "DELETE",
            headers: {"Content-Type": "application/json"},
        }

        let id = $(this)
            .attr("data-id")

        fetch(`http://localhost:8080/api/posts/${id}`, request)
            .then(res => {
                console.log(res.status);
                createView("/posts");
            })
            .catch(error => {
                console.log(error)
                createView("/posts")
            })
    })
}