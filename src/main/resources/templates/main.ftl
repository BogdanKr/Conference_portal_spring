<#import "parts/common.ftl" as mymacro>
<#include "parts/security.ftl">


<@mymacro.page>
 <#if RequestParameters.logout??>
        <div class="alert alert-info" align="center">
            <strong><@spring.message "logout"/></strong>
            <br><@spring.message "you_logged_out"/>
        </div>
    </#if>
    <h5> ${name} <#if isAdmin><@spring.message "greeting_admin"/></#if></h5>
    <@spring.message "welcome_info"/>
    <#if !user??>
        <br> <@spring.message "please_login"/>
        <br>
        <a class="btn btn-primary" href="/login" role="button"><@spring.message "login"/></a>
        <a class="btn btn-primary" href="/registration" role="button"><@spring.message "registration"/></a>
    </#if>

</@mymacro.page>
