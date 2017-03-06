 $(function(){  
            function initTableCheckbox() {  
                var $thr = $('table thead tr');  
                var $checkAllTh = $('<th><input type="checkbox" id="checkAll" name="checkAll" /></th>');  
                /*将全选/反选复选框添加到表头最前，即增加一列*/  
                $thr.prepend($checkAllTh);  
                /*“全选/反选”复选框*/  
                var $checkAll = $thr.find('input');  
                $checkAll.click(function(event){  
                    /*将所有行的选中状态设成全选框的选中状态*/  
                    $tbr.find('input').prop('checked',$(this).prop('checked'));  
                    /*并调整所有选中行的CSS样式*/  
                    if ($(this).prop('checked')) {  
                        $tbr.find('input').parent().parent().addClass('warning');  
                    } else{  
                        $tbr.find('input').parent().parent().removeClass('warning');  
                    }  
                    /*阻止向上冒泡，以防再次触发点击操作*/  
                    event.stopPropagation();  
                });  
                /*点击全选框所在单元格时也触发全选框的点击操作*/  
                $checkAllTh.click(function(){  
                    $(this).find('input').click();  
                });  
                var $tbr = $('table tbody tr');  
                var $checkItemTd = $('<td><input type="checkbox" name="checkItem" /></td>');  
                /*每一行都在最前面插入一个选中复选框的单元格*/  
                $tbr.prepend($checkItemTd);  
                /*点击每一行的选中复选框时*/  
                $tbr.find('input').click(function(event){  
                    /*调整选中行的CSS样式*/  
                    $(this).parent().parent().toggleClass('warning');  
                    /*如果已经被选中行的行数等于表格的数据行数，将全选框设为选中状态，否则设为未选中状态*/  
                    $checkAll.prop('checked',$tbr.find('input:checked').length == $tbr.length ? true : false);  
                    /*阻止向上冒泡，以防再次触发点击操作*/  
                    event.stopPropagation();  
                });  
                /*点击每一行时也触发该行的选中操作*/  
                $tbr.click(function(){  
                    $(this).find('input').click();  
                });  
            }  
            initTableCheckbox();  
        });