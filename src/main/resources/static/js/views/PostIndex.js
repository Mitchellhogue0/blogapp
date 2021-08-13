export default function PostIndex(props) {
    return `
        <header>
            <h1>Posts Page</h1>
        </header>
        <main>
<!--        CREATE FORM         -->
                    <form>
                        <div>
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
                                            <h4>${post.content}</h4>`).join('')}   
            </div>
        </main>
    `;
}


export function PostsEvent() {
    //TODO: add event listeners for create/edit/delete, get data, send fetch
    $("#create-btn").click(function (){
        let title = $("#create-post-title").val();
        let content = $("#create-post-content").val();
        console.log(title)
        console.log(content)

        fetch("http://localhost:8080/posts", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            redirect: 'follow',
            body: JSON.stringify({
                "title": title,
                "content": content
            })
        }).then(function(response) {
            return response.json();
        }).then(function(data) {
            console.log(data);
        });
    });

    fetch("http://localhost:8080/posts", {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        },
        redirect: 'follow'
    }).then(function(response) {
        return response.json();
    }).then(function(data) {
        console.log(data);
    });

}