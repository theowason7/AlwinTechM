document.addEventListener("DOMContentLoaded", () => {
    const reviewForm = document.getElementById("review-form");
    const reviewsContainer = document.getElementById("reviews-container");

    // Load existing reviews from localStorage
    function loadReviews() {
        const savedReviews = JSON.parse(localStorage.getItem("movieReviews")) || [];
        savedReviews.forEach(({ name, text, date }) => displayReview(name, text, date));
    }

    // Function to display a review
    function displayReview(name, text, date) {
        const reviewItem = document.createElement("div");
        reviewItem.classList.add("review-item");
        reviewItem.innerHTML = `<strong>${name}</strong> <span>(${date})</span>: <p>${text}</p>`;
        reviewsContainer.appendChild(reviewItem);
    }

    // Handle form submission
    reviewForm.addEventListener("submit", (e) => {
        e.preventDefault();

        const movieName = document.getElementById("movie-name").value.trim();
        const reviewText = document.getElementById("review-text").value.trim();
        
        if (movieName === "" || reviewText === "") {
            alert("Please enter both your name and a review.");
            return;
        }

        const currentDate = new Date().toLocaleDateString();
        displayReview(movieName, reviewText, currentDate);

        // Save review to localStorage
        const savedReviews = JSON.parse(localStorage.getItem("movieReviews")) || [];
        savedReviews.push({ name: movieName, text: reviewText, date: currentDate });
        localStorage.setItem("movieReviews", JSON.stringify(savedReviews));

        reviewForm.reset();
    });

    // Load stored reviews on page load
    loadReviews();
});
