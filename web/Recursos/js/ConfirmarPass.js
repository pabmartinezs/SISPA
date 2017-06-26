function val() {
    if (frm.password.value === "")
    {
        alert("Ingrese Password");
        frm.password.focus();
        return false;
    }
    if ((frm.password.value).length < 3)
    {
        alert("Mínimo contraseña 3 caracteres");
        frm.password.focus();
        return false;
    }
    if (frm.confirmpassword.value === "")
    {
        alert("Ingrese Confirmar Password");
        return false;
    }
    if (frm.confirmpassword.value != frm.password.value)
    {
        alert("Las claves no son iguales");
        return false;
    }

    return true;
}



