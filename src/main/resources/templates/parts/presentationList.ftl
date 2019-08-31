<#include "security.ftl">

<table>
    <thead>
    <tr>
        <th><@spring.message "conference_day"/></th>
        <th><@spring.message "speaker"/> </th>
        <th><@spring.message "theme"/> </th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <#list presentations! as presentation>
        <tr>
            <td>${presentation.conference.date}</td>
            <td>${presentation.author.firstName}</td>
            <td>${presentation.theme}</td>
            <#if (presentation.author.id==currentUserId || isAdmin)>
                <td><a href="/presentation/${presentation.conference.id}?presentation=${presentation.id}"><@spring.message "edit"/></a></td>
                <td><a class="ml-2" href="/presentation/delete/${presentation.id}">Delete</a></td>
            </#if>

        </tr>
    <#else >
        <@spring.message "no_presentations"/>
    </#list>
    </tbody>
</table>