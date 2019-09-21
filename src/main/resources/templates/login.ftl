<#import "parts/common.ftl" as mymacro>
<#import "parts/login.ftl" as mylogin>

<@mymacro.page>
    <@spring.message "login_page"/>

    <#if RequestParameters.error??>
        <div class="alert alert-danger" align="center">
            <br><@spring.message "invalid_name_password"/>
        </div>
    <#elseif RequestParameters.logout??>
        <div class="alert alert-info" align="center">
            <strong><@spring.message "logout"/></strong>
            <br><@spring.message "you_logged_out"/>
        </div>
    </#if>
    <#if message??>
        <div class="alert alert-success" role="alert">
            ${message}
        </div>
    </#if>
    <@mylogin.login "/login" false "Login"/>


</@mymacro.page>