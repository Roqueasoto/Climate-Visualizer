$(document).ready(function(){
    $(".header").height($(window).height());
});

$(document).ready(function(){
    $("body").css("display", "none");
    $("body").fadeIn(1000);

    $("a.transition").click(function(event){
        event.preventDefault();
        linkLocation = this.href;
        $("body").fadeOut(500, redirectPage);
    })

    function redirectPage(){
        window.location = linkLocation;
    }
});