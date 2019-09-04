 $('.table tbody').on('click', '.btn-dark', function () {
        $(".btn-c").hide();
        $(".btn-u").show();
        var currentRow = $(this).closest('tr');
        var ids = document.getElementsByClassName('input-id');
        [].forEach.call(ids, function (id) {
        id.value = currentRow.find('td:eq(0)').text();
        });
        var names = document.getElementsByClassName('input-name');
        [].forEach.call(names, function (name) {
            name.value = currentRow.find('td:eq(1)').text();
        });
        $('#subject').val(currentRow.find('td:eq(2)').data('val')).trigger('change');
    })
        .on('click', '.pointer', function () {
            var currentId = $(this).closest('tr').find('td:eq(0)').text();
            document.location.href="http://localhost:8080/students?groupId="+currentId;
        });
    $(document).ready(function() {
        $(".edit-teacher").click(function () {
            $("#teacher-form").show();
            $("#group-form").hide();
            $("#subject-form").hide();
        });
        $(".edit-group").click(function () {
            $("#group-form").show();
            $("#teacher-form").hide();
            $("#subject-form").hide();
        });
        $(".edit-subject").click(function () {
            $("#subject-form").show();
            $("#group-form").hide();
            $("#teacher-form").hide();
        });
        $(".btn-primary").click(function () {
            $(".btn-c").show();
            $(".btn-u").hide();
        });
    });
