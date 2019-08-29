<#import "parts/common.ftl" as mymacro>
<#import "parts/login.ftl" as mylogin>

<@mymacro.page>
<div class="mb-1"> <@spring.message "add_new_user"/> </div>

    <#if message??>
        <div class="alert alert-danger" role="alert">
            ${message}
        </div>
    </#if>

<@mylogin.login "/registration" true "Registration"/>

    <a href="/login"><@spring.message "login"/></a>

</@mymacro.page>