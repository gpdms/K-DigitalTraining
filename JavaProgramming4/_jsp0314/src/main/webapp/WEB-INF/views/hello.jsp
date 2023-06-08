<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<jsp:include page="module/top2.jsp" />

<h1>Hello, ${name}!</h1>
<button id="aaa" class="btn btn-primary">클릭</button>

<jsp:include page="module/bottom2.jsp" />

<script>
    const modal = new bootstrap.Modal(document.querySelector(".modal"));
    var grade = 0;
    $('.starrr').starrr({
        rating: grade,
        change: function (e, value) {
            if (value) {
                console.log(value);
                grade = value;
            }
        }
    });
    $('.savBtn').click(function () {
        let idVal = 1000;
        let contVal = '연습';
        let data = {id : idVal, grade : grade, content: contVal};
        $.ajax({
            url:'/review',
            type: "POST",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "text",
            success: function(result) {
                console.log("result: " + result);
                //self.location.reload();
            },
            error: function (e) {
                console.log(e);
            }
        });
        modal.hide();
    })

    $('#aaa').click(function () {
        modal.show();
    })



    // document.querySelector(".savBtn").addEventListener("click", function(e) {
    //     console.log("savBtn");
    // });
</script>
</body>
</html>