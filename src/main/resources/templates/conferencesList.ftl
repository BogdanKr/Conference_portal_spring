<#import "parts/common.ftl" as mymacro>
<#include "parts/security.ftl">


<@mymacro.page>

    <table>
        <thead>
        <tr>
            <th><@spring.message "conference_day"/></th>
            <th style="text-align: center"><@spring.message "subject"/> </th>
            <th><@spring.message "total"/></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <#if conferences??>
            <#list conferences.content! as conference>
                <tr>
                    <td>${conference.date}</td>
                    <td>${conference.subject}</td>
                    <td style="text-align: center"> ${conference.registrations}</td>
                    <td><a href="/conference/${conference.id}/like" style="color: #b10821">
                            <#if conference.meRegistered>
                                <i class="fas fa-registered"><@spring.message "registered"/> </i>
                            <#else>
                                <i class="far fa-registered"> </i>
                            </#if>
                        </a>
                    </td>
                    <#if (isAdmin)>
                        <td><a href="/conference/${conference.id}"><@spring.message "edit"/></a></td>
                    </#if>
                </tr>
            <#else>
                <@spring.message "no_conferences"/>
            </#list>
        </#if>

        </tbody>
    </table>

</@mymacro.page>