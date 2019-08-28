<#include "security.ftl">

<table>
    <thead>
    <tr>
        <th>Conference day</th>
        <th>Speaker</th>
        <th>Theme</th>
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
                <td><a href="/presentation/${presentation.conference.id}?presentation=${presentation.id}">Edit</a></td>
            </#if>

        </tr>
    <#else >
        No Message
    </#list>
    </tbody>
</table>