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
