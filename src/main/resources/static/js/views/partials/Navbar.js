export default function Navbar(props) {
    return `
        <nav id="nav">
            <a class="a-tags" href="/" data-link>Home</a>
            <a class="a-tags" href="/posts" data-link>Posts</a>
            <a class="a-tags" href="/about" data-link>About</a>
            <a class="a-tags" href="/login" data-link>Login</a>
            <a class="a-tags" href="/register" data-link>Register</a>
            <a class="a-tags" href="/user" data-link>Profile</a>
        </nav>
    `;
}