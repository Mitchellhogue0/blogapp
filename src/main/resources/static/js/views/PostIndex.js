import createView from "../createView.js";

export default function PostIndex(props) {
    return `
         <header>
            <h1>Posts Page</h1>
        </header>
        <main>
            <!--        CREATE FORM         -->
            <form>
                <div class="post">
                    <div>
                        <span>Post Title: </span>
                    </div>
                    <input id="create-post-title" type="text">
                    <div>
                        <span>Post Content: </span>
                    </div>
                    <input id="create-post-content" type="text">
                </div>
                <button id="create-btn">Submit</button>
            </form>
            <div class="post-container">
                ${props.posts.map(post => `<h3 class="post-title" data-id="${post.id}">${post.title}</h3>
                <h4>${post.content}</h4>
                <button class="edit-btn" data-id="${post.id}">edit</button>

                `).join('')}
            </div>
        </main>
    `;
}


export function PostsEvent() {
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

        fetch("http://localhost:8080/posts", request)
            .then(res => {
                console.log(res.status)
                createView("/posts")
            }).catch(error => {
            console.log(error);
            createView("/posts");
        });
    });
}


function postsEvent () {
    //createEvent()
    //editEvent()
}

function editEvent() {
    $(".edit-btn").click(function (){
        console.log("edit event fired off");
        $(this).siblings(".edit-title, .edit-content");
        $(this).text("Save");
    })
}