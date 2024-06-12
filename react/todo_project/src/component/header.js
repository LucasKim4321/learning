const Header = ()=> {
    return (
    <div className="alert alert-success">
        <h3>오늘은 🤣🤣🤣</h3>
        <h1>{new Date().toDateString()}</h1>
    </div>
    )
}

export default Header;