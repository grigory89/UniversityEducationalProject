  var data = [];
    $('.table tbody').on('click', '.btn-dark', function () {
        var currentRow = $(this).closest('tr');
        document.getElementById("lessonId").value = currentRow.find('td:eq(0)').text();
        document.getElementById("date").value = currentRow.find('td:eq(1)').text();
        var teacherId = currentRow.find('td:eq(2)').data('val');
        var subjectId = currentRow.find('td:eq(3)').data('val');
        var room = currentRow.find('td:eq(4)').text();
        $('#teacher').val(teacherId).trigger('change');
        $('#subject').val(subjectId).trigger('change');
        $('#classroom').val(room).trigger('change');
        var currentIndex = currentRow[0].rowIndex;
        var length = document.getElementById('table1').rows[currentIndex].cells.length;
        var groups = [];
        for (var i = 5; i < (length-2); i++) {
            groups.push (currentRow.find('td').eq(i).data('value'));
        }
        $('#groups').val(groups).trigger('change');
    })
        .on('click', '.pointer', function () {
            var currentId = $(this).closest('tr').find('td:eq(0)').text();
            document.location.href="${pageContext.request.contextPath}/groups?lessonId="+currentId;
        });
    $(document).ready(function() {
        $(".btn-dark").click(function () {
            $("#form").show();
            $("#update").show();
            $('#create').hide();
        });
        $("#createForm").click(function () {
            $("#form").show();
            $("#create").show();
            $('#update').hide();
        })
    });
    $(".js-example-tags").select2({
        tags: true
    });
    $(".js-example-placeholder-multiple").select2({
        placeholder: "Add groups to lesson"
    });
    function select() {
        var subjectId = document.getElementById("teacher").value[0];
        $('#subject').val(subjectId).trigger('change');
    }
    $("#teacher").change(function () {
        var subjectId = $(this).find(':selected').data('sub');
        $('#subject').val(subjectId).trigger('change');
    });
