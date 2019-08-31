<#macro pager url conferences >

    <div class="row sm ml-0">
        <ul class="pagination pagination-sm mb-1 mr-1">
            <li class="page-item disabled">
                <a class="page-link" href="#" tabindex="-1"><@spring.message "elements_per_page"/></a>
            </li>
            <#list [3, 6, 12, 24] as c>
                <#if c==conferences.getSize()>
                    <li class="page-item active">
                        <a class="page-link" href="#" tabindex="-1">${c}</a>
                    </li>
                <#else>
                    <li class="page-item">
                        <a class="page-link" href="${url}?page=${conferences.getNumber()}&size=${c}"
                           tabindex="-1">${c}</a>
                    </li>
                </#if>
            </#list>
        </ul>
        <ul class="pagination pagination-sm mb-1">
            <li class="page-item disabled">
                <a class="page-link" href="#" tabindex="-1"><@spring.message "pages"/></a>
            </li>
            <#list 1..conferences.getTotalPages() as p>
                <#if (p-1)==conferences.getNumber()>
                    <li class="page-item active">
                        <a class="page-link" href="#" tabindex="-1">${p}</a>
                    </li>
                <#else>
                    <li class="page-item">
                        <a class="page-link" href="${url}?page=${p-1}&size=${conferences.getSize()}"
                           tabindex="-1">${p}</a>
                    </li>
                </#if>
            </#list>
        </ul>
    </div>
</#macro>