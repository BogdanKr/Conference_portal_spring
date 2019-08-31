<#import "parts/common.ftl" as mymacro>
<#include "parts/security.ftl">


<@mymacro.page>

    <table>
        <thead>
        <tr>
            <th><@spring.message "conference_day"/></th>
            <th><@spring.message "subject"/> </th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <#list conferences.content! as conference>
            <tr>
                <td>${conference.date}</td>
                <td>${conference.subject}</td>
                <#if (isAdmin)>
                    <td><a href="/conference/${conference.id}"><@spring.message "edit"/></a></td>
                </#if>

            </tr>
        <#else >
            <@spring.message "no_conferences"/>
        </#list>
        </tbody>
    </table>

</@mymacro.page>