<#import "parts/common.ftl" as mymacro>
<#import "parts/login.ftl" as mylogin>

<@mymacro.page>
    Login page

    <#if RequestParameters.error??>
        <div class="alert alert-danger" align="center">
            <strong>Invalid Login!</strong>
            <br>Invalid username or password
        </div>
    <#elseif RequestParameters.logout??>
        <div class="alert alert-info" align="center">
            <strong>Logged out!</strong>
            <br>You have Logged out of Conference portal
        </div>
    </#if>
    <#if message??>
        <div class="alert alert-success" role="alert">
            ${message}
        </div>
    </#if>
    <@mylogin.login "/login" false "Login"/>


</@mymacro.page>