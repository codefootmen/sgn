// window.addEventListener('load', _ => {
//     Array.from(document.querySelectorAll(".expandable")).forEach(y => {
//         y.nextElementSibling.style.display = "none";
//     })
// });

Array.from(document.querySelectorAll(".expandable")).forEach(x => {
    x.addEventListener("click", function (e) {
        let collapse = e.target.nextElementSibling;
        (collapse.style.display === "block") ?
            collapse.style.display = "none" :
            collapse.style.display = "block";
    });
});