<#include "security.ftl">
<#import "login.ftl" as mylogin>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/<#if user??>welcome</#if>">Conference Portal</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/welcome"><i class="fas fa-home"></i> </a>
            </li>
            <li class="nav-item">
                <#if isAdmin>
                    <a class="nav-link" href="/presentation/all">All presentations </a>
                </#if>
                <#if isSpeaker>
                <a class="nav-link" href="/presentation/all">My presentations </a>
                </#if>
            </li>
            <#if user??>
                <li class="nav-item">
                    <a class="nav-link" href="/registration/${user.id}">Edit profile</a>
                </li>
            </#if>
            <#if isAdmin>
                <li class="nav-item">
                    <a class="nav-link" href="/user/userList">User list </a>
                </li>
            </#if>

        </ul>

        <div class="navbar-text mr-3"> ${name}</div>
        <#if name!="guest">
            <div class="mr-3">
                <@mylogin.logout />
            </div>
        </#if>
    </div>
</nav>