<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:basic> <!--prefix이름: basic.tag이름-->

    <jsp:attribute name="header">
        <h1>Hello, ${name}!</h1>
        <button id="aaa" class="btn btn-primary">클릭</button>
        <div class="modal" tabindex="-1">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Modal title</h5>
                        <button type="button" class="btn-close"
                                data-bs-dismiss="modal"></button>
                    </div>
                    <div class="modal-body">
                        <p>Modal body text goes here.</p>
                        <div class="form-group">
                            <label>Grade <span class="grade" id='star1'></span></label>
                            <div class="starrr"></div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn-secondary"
                                data-bs-dismiss="modal">Close</button>
                        <button type="button"
                                class="btn-primary savBtn">Save</button>
                    </div>
                </div>
            </div>
        </div>
    </jsp:attribute>
    <jsp:attribute name="footer"></jsp:attribute>

<jsp:body>

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
</jsp:body>
</t:basic>