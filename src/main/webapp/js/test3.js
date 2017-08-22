function compute(op) {
    var num1, num2;
    num1 = parseFloat(document.myform.num1.value);
    num2 = parseFloat(document.myform.num2.value)
    if (op == "+")
        document.myform.result.value = num1 + num2;
    if (op == "-")
        document.myform.result.value = num1 - num2;
    if (op == "*")
        document.myform.result.value = num1 * num2;
    if (op == "/")
        document.myform.result.value = num1 / num2;
}
function result2() {
    var temp = document.getElementById("result").value;
    alert(temp);

    
}