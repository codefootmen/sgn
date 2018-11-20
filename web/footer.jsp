</section>
<footer class="footer">
    <div class="content has-text-centered">
        <p>
            <strong>SGN</strong> by <a href="https://github.com/codefootmen">Code Footmen</a>. The source code is licensed
            <a href="https://opensource.org/licenses/GPL-3.0">GPL-3.0</a>.
        </p>
    </div>
</footer>

<script async type="text/javascript">
    (function() {
        var burger = document.querySelector('.burger');
        var menu = document.querySelector('#'+burger.dataset.target);
        burger.addEventListener('click', function() {
            burger.classList.toggle('is-active');
            menu.classList.toggle('is-active');
        });
    })();
</script>