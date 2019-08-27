<#import "parts/common.ftl" as mymacro>
<#include "parts/security.ftl">


<@mymacro.page>
 <#if RequestParameters.logout??>
        <div class="alert alert-info" align="center">
            <strong>Logged out!</strong>
            <br>You have Logged out of Conference portal
        </div>
    </#if>
    <h5>Hello ${name} <#if isAdmin>you are ADMIN !</#if></h5>
    You are on Conference portal,<br> here you could view conferences and check for visit
    <#if !user??>
        <br> but login or register before please
        <br>
        <a class="btn btn-primary" href="/login" role="button">Login</a>
        <a class="btn btn-primary" href="/registration" role="button">Registration</a>
    </#if>
<br>
    <a class="btn btn-primary" href="/testData" role="button">TestDataPicker</a>


    <#include "parts/datePicker.ftl">




</@mymacro.page>
