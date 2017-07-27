$(document).ready(function(){
    $('td').click(function(){
        var val = $(this).attr('id');
        $(this).attr('bgcolor','red');
        $('#submit').click(function () {
            var value = $("#value").val();
            $.ajax({
                url:'/updateval/'+val,
                metod: "GET",
                data:{valuation : value},
            });
        });
    });
});
