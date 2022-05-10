/**
 * 입력 항목 validation
 * @returns {boolean}
 */
function invalid(){
    let check = true;
    let toDoValid = true;

    //한글 영문 숫자 띄어쓰기 가능
    const regToDo = /^[가-힣a-zA-Z0-9\s]+$/;

    //'할 일' 형식 확인
    if (regToDo.test($("#todo").val()) === false) {
        console.log(1);
        $("#todo").addClass('is-invalid');
        $("#todo").removeClass('is-valid');
        $(".valid-feedback").text("문자, 숫자, 영어만 입력하세요.");

        toDoValid = false;
    }
    //'할 일' 값 null 확인
    if ($("#todo").val() == '') {
        console.log(2);
        $("#todo").addClass('is-invalid');
        $("#todo").removeClass('is-valid');
        $(".valid-feedback").text("입력 바랍니다.");
        toDoValid = false;
    }
    //할 일 유효성 통과시 유효성 success 처리
    if (toDoValid) {
        console.log(5);
        $("#todo").removeClass('is-invalid');
        $("#todo").addClass('is-valid');
    }

    //할 일 유효성 실패 시 false 리턴
    if (!toDoValid) check = false;
    return check;
}