function checkform() {
    f = document.form1;
    uname = f.name.value;
    uselect1 = f.select1.value;
    uselect2 = f.select2.value;
    umail = f.email.value;
    // 判断用户名Email等是否为空
    if (isName() && isEmail() && isDuo()) {
        ufile = f.file.value;
        if (ufile.length != 0) {
            document.write("你的物业名称为   " + uname + "<br>");
            document.write("你的物业类别为   " + uselect1 + "<br>");
            document.write("你的租金范围为   " + uselect2 + "<br>");
            document.write("你的电子邮件地址为   " + umail + "<br>");
            document.write("你的公交路线为   " + get + "<br>");
            document.write("你你选择的图片为   " + "<img src=" + ufile + ">");
        } else {
            alert("你为输入图片，请重新输入！");
            f.file.focus();
            return false;
        }
    }
}

/**
 * 验证输入的名字
 */
function isName() {
    if (f.name.value == "") {
        alert("请输入物业名称！");
        f.name.focus();
        return false;
    }
    return true;
}

/**
 * 验证输入的 Email
 */
function isEmail() {
    var i;
    a = f.email.value.indexOf("@");
    b = f.email.value.indexOf(".");
    if (f.email.value == "") {
        alert("你为输入电子邮件，请重新输入！");
        f.email.focus();
        return false;
    }
    if (a == -1) {
        alert("你的电子邮件没有包含'@'字符，请重新输入！");
        f.email.focus();
        return false;
    }
    if (b == -1) {
        alert("你的电子邮件没有包含'.'字符，请重新输入！");
        f.email.focus();
        return false;
    }
    if (a > b) {
        alert("你的电子邮件中@字符必须在.字符的前面，请重新输入！");
        f.email.focus();
        return false;
    }
    return true;
}

/**
 * 验证多选
 */
function isDuo() {
    get = "";
    if (f.checkbox1.checked == true) {
        get = get + f.checkbox1.value + "&nbsp;";
    }
    if (document.form1.checkbox2.checked == true) {
        get = get + document.form1.checkbox2.value + "&nbsp;";
    }
    if (document.form1.checkbox3.checked == true) {
        get = get + document.form1.checkbox3.value + "&nbsp;";
    }
    if (document.form1.checkbox4.checked == true) {
        get = get + document.form1.checkbox4.value + "&nbsp;";
    }
    if (document.form1.checkbox5.checked == true) {
        get = get + document.form1.checkbox5.value + "&nbsp;";
    }
    if (get == "") {
        alert("你没有选择公交路线！")
        return false;
    } else {
        return true;
    }
}