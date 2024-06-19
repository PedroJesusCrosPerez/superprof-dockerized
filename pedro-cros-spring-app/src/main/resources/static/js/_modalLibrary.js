function launchConfirmModal(onConfirm, onCancel) {

    Swal.fire({
        title: '¿Estás seguro?',
        text: "¡No podrás revertir los cambios!",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        confirmButtonText: 'Sí, ¡eliminar!',
        cancelButtonColor: '#d33'
    }).then((result) => {
        if (result.isConfirmed) {
            onConfirm();
            Swal.fire(
                '¡Eliminado!',
                'Se ha eliminado con éxito.',
                'success'
            )
        } else {
            onCancel();
        }
    })
}

function launchSuccessModal(title, text) {
    Swal.fire(title, text, 'success')
}

function launchErrorModal(title, text) {
    Swal.fire(title, text, 'error')
}

function launchUpdateConfirmModal(field, value, onConfirm, onCancel) {
    Swal.fire({
        title: "Are you sure?",
        text: "You won't be able to revert this!",
        icon: "warning",
        showCancelButton: true,
        confirmButtonColor: "#3085d6",
        cancelButtonColor: "#d33",
        confirmButtonText: "Yes, delete it!"
    }).then((result) => {
        if (result.isConfirmed) {
            Swal.fire("¡¡Actualización completada!!", field + " se ha actualizado con éxito ==> " + value, 'success')
            onConfirm(field, value);
        } else {
            Swal.fire("Cancelado", field + " no se ha podido actualizar, lo sentimos.", 'error')
            onCancel();
        }
    });
}
