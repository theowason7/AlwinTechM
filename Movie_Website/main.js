document.addEventListener("DOMContentLoaded", function () {
    console.log("Movie review site loaded!");

    // 🎯 SEARCH FUNCTIONALITY
    const searchBar = document.getElementById("search-bar");
    if (searchBar) {
        searchBar.addEventListener("input", function () {
            let query = searchBar.value.toLowerCase();
            let movies = document.querySelectorAll(".movie");

            movies.forEach(movie => {
                let title = movie.querySelector("h2").textContent.toLowerCase();
                if (title.includes(query)) {
                    movie.style.display = "block";
                } else {
                    movie.style.display = "none";
                }
            });
        });
    }

    // 🎬 DYNAMIC MOVIE DETAILS NAVIGATION
    const movieLinks = document.querySelectorAll(".read-more");
    movieLinks.forEach(link => {
        link.addEventListener("click", function (event) {
            console.log("Navigating to: " + link.getAttribute("href"));
        });
    });

    // 🔝 SMOOTH SCROLLING
    const scrollLinks = document.querySelectorAll('a[href^="#"]');
    scrollLinks.forEach(link => {
        link.addEventListener("click", function (event) {
            event.preventDefault();
            let targetId = this.getAttribute("href").substring(1);
            let targetElement = document.getElementById(targetId);

            if (targetElement) {
                window.scrollTo({
                    top: targetElement.offsetTop - 50,
                    behavior: "smooth"
                });
            }
        });
    });

});
