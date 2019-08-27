<#import "parts/common.ftl" as mymacro>
<#include "parts/security.ftl">


<@mymacro.page>

    <h5>Hello ${name} <#if isAdmin>you are ADMIN !</#if></h5>
    You are on Conference portal,<br> here you could view conferences and check for visit
    <br>

    <#include "parts/datePicker.ftl">
    <table>
        <thead>
        <tr>
            <th>Conference date</th>
            <th>Subject</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <#list conferences! as conference>
            <tr>
                <td>${conference.date}</td>
                <td>${conference.subject}</td>
                <td></td>
                <#if isAdmin>
                <td><a href="/conference/${conference.id}">Edit</a> </td>
                </#if>
            </tr>
        <#else >
            No conferences
        </#list>
        </tbody>
    </table>

</@mymacro.page>
