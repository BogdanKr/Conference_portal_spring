<#include "security.ftl">
<#import "login.ftl" as mylogin>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/<#if user??>welcome</#if>"><@spring.message "title"/></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/welcome"><i class="fas fa-home"></i> </a>
            </li>
            <#if user??>
            <li class="nav-item"><a class="nav-link" href="/conference_all"><@spring.message "all_conferences"/> </a>
            </li>
            <li class="nav-item"><a class="nav-link" href="/presentation/"><@spring.message "all_presentations"/> </a>
            </li>
            </#if>
            <#if isSpeaker>
                <li class="nav-item"> <a class="nav-link" href="/presentation/all_my"><@spring.message "my_presentations"/></a></li>
            </#if>

            <#if user??>
                <li class="nav-item"><a class="nav-link" href="/my_registrations"><@spring.message "my_registrations"/> </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/registration/${user.id}"><@spring.message "edit_profile"/></a>
                </li>
            </#if>
            <#if isAdmin>
                <li class="nav-item">
                    <a class="nav-link" href="/user/userList"><@spring.message "user_list"/> </a>
                </li>
            </#if>

        </ul>

        <div class="navbar-text mr-3"> ${name}</div>
        <a href="?lang=ua">
            <img alt="Українська" height="32" src="/static/UA.ico" title="Ukrainian" width="32">
        </a>
        <a href="?lang=en">
            <img alt="Англійська" height="32" src="/static/United-Kingdom.ico" title="English" width="32">
        </a>
        <#if name!="guest">
            <div class="mr-3">
                <@mylogin.logout />
            </div>
        </#if>
    </div>
</nav>