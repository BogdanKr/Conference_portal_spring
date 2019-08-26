<#import "parts/common.ftl" as mymacro>
<#include "parts/security.ftl">


<@mymacro.page>

    <h5>Hello ${name} <#if isAdmin>you are ADMIN !</#if></h5>
You are on Conference portal,<br> here you could view conferences and check for visit
    <br> but login or register before please
    <br>
    <a class="btn btn-primary" href="/login" role="button">Login</a>
    <a class="btn btn-primary" href="/registration" role="button">Registration</a>


</@mymacro.page>
