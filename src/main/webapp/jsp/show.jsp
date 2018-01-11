<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="java.io.*" %>

<%
    String filedownload = (String) "D:\\output.jpg";
    FileInputStream ini = new FileInputStream(filedownload); // 以byte流的方式打开文件
    int i = ini.available(); //得到文件大小
    byte data[] = new byte[i];
    ini.read(data);  //读数据
    response.setContentType("image/*"); //设置返回的文件类型
    OutputStream outi = response.getOutputStream(); //得到向客户端输出二进制数据的对象
    outi.write(data);  //输出数据
    outi.flush();
    outi.close();
    ini.close();
%>