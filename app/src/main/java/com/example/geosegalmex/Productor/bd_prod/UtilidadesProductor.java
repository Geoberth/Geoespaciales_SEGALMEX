package com.example.geosegalmex.Productor.bd_prod;

public class UtilidadesProductor {


    //Identificacion del cuestionario
    public static final String TABLA_CUESTIONARIO = "TB_CUESTIONARIOS";
    public static final String COLUMN_FOLIO_ENCUESTA = "FOLIO";
    public static final String COLUMN_FECHA_ENCUESTA = "FECHAENC";
    public static final String COLUMN_HORA_ENCUESTA = "HORAENC";
    public static final String COLUMN_PROYECTO = "PROYECTO";
    public static final String COLUMN_ESTATUS = "ESTATUS";
    public static final String COLUMN_MOD_USO = "MOD_USO";
    public static final String COLUMN_COBERTURA = "COBERTURA";
    public static final String COLUMN_MODALIDAD = "MODALIDAD";
    public static final String COLUMN_CULTIVO_ESTI = "CULTIVO_ESTI";
    public static final String COLUMN_MODALIDAD_ESTI = "MODALIDAD_ESTI";
    public static final String COLUMN_ALTURA_ESTI = "ALTURA_ESTI";
    public static final String COLUMN_SINIESTRO_ESTI = "SINIESTRO_ESTI";
    public static final String COLUMN_FENO_ESTI = "FENO_ESTI";
    public static final String COLUMN_SUELO_ESTI = "SUELO_ESTI";
    public static final String COLUMN_PREDIO_ESTI = "PREDIO_ESTI";
    public static final String COLUMN_VARIEDAD_ESTI = "VARIEDAD_ESTI";
    public static final String COLUMN_MALEZA_ESTI = "MALEZA_ESTI";
    public static final String COLUMN_CULT_ESTI = "CULT_ESTI";
    public static final String COLUMN_ASOCIA_ESTI = "ASOCIA_ESTI";
    public static final String COLUMN_NORTE_ESTI = "NORTE_ESTI";
    public static final String COLUMN_SUR_ESTI = "SUR_ESTI";
    public static final String COLUMN_ESTE_ESTI = "ESTE_ESTI";
    public static final String COLUMN_OESTE_ESTI = "OESTE_ESTI";
    public static final String COLUMN_OBSERVACIONES = "OBSERVACIONES";

    public static final String CREAR_TABLA_CUESTIONARIO2 = "CREATE TABLE " + TABLA_CUESTIONARIO + "("
            + COLUMN_FOLIO_ENCUESTA + " VARCHAR PRIMARY KEY, "
            + COLUMN_FECHA_ENCUESTA + " VARCHAR, "
            + COLUMN_HORA_ENCUESTA + " VARCHAR, "
            + COLUMN_PROYECTO + " VARCHAR, "
            + COLUMN_ESTATUS + " VARCHAR, "
            + COLUMN_MOD_USO + " VARCHAR, "
            + COLUMN_COBERTURA + " VARCHAR, "
            + COLUMN_MODALIDAD + " VARCHAR, "
            + COLUMN_CULTIVO_ESTI + " VARCHAR, "
            + COLUMN_MODALIDAD_ESTI + " VARCHAR, "
            + COLUMN_ALTURA_ESTI + " VARCHAR, "
            + COLUMN_SINIESTRO_ESTI + " VARCHAR, "
            + COLUMN_FENO_ESTI + " VARCHAR, "
            + COLUMN_SUELO_ESTI + " VARCHAR, "
            + COLUMN_PREDIO_ESTI + " VARCHAR, "
            + COLUMN_VARIEDAD_ESTI + " VARCHAR, "
            + COLUMN_MALEZA_ESTI + " VARCHAR, "
            + COLUMN_CULT_ESTI + " VARCHAR, "
            + COLUMN_ASOCIA_ESTI + " VARCHAR, "
            + COLUMN_NORTE_ESTI + " VARCHAR, "
            + COLUMN_SUR_ESTI + " VARCHAR, "
            + COLUMN_ESTE_ESTI + " VARCHAR, "
            + COLUMN_OESTE_ESTI + " VARCHAR, "
            + COLUMN_OBSERVACIONES + " VARCHAR); " ;

    //Tabla Informacion del Productor
    public static final String TABLA_PRODUCTOR = "TB_PRODUCTORES";

    public static final String COLUMN_NUMERO_PRODUCTOR = "IDPRODUCTOR";
    public static final String COLUMN_FOLIO_ENC = "FOLIO";
    public static final String COLUMN_NUMERO_CAPTURISTA = "IDCAPTURIS";

    public static final String COLUMN_RESPONSABLEUPF_PRODUCTOR = "RESPONSUPF";
    public static final String COLUMN_PRODUCTOR_RELACION_UPF = "RELUPF";
    public static final String COLUMN_NOMBRE_PRODUCTOR = "NOMPRO";
    public static final String COLUMN_APELLIDO_PATERNO_PROD = "APPAPRO";

    public static final String COLUMN_APELLIDO_MATERNO_PROD = "APMAPRO";
    public static final String COLUMN_SEXO_PROD = "SEXO";
    public static final String COLUMN_EDAD_PROD = "EDAD";

    public static final String COLUMN_LEER_PROD = "LEER";
    public static final String COLUMN_ESCRIBIR_PROD = "ESCRIBIR";
    public static final String COLUMN_ESTUDIOS_PROD = "ESTUDIPR";

    public static final String COLUMN_SITUACION_ESTUDIOS_PROD = "SNEST";
    public static final String COLUMN_PUEBLO_ORIGINARIO_PROD = "PUEBLOOR";
    public static final String COLUMN_CUAL_PUEBLO_PROD = "PUEORPR";

    public static final String COLUMN_LENGUA_ORIGINARIA_PROD = "LENGUAOR";
    public static final String COLUMN_CUAL_LENGUA_PROD = "LENGORPR";

    public static final String COLUMN_ACTCOMERCIO = "ACTCOMERCIO";
    public static final String COLUMN_ACTTRANSFORMACION = "ACTTRANSFORMACION";
    public static final String COLUMN_ACTAGRICULTURA = "ACTAGRICULTURA";
    public static final String COLUMN_ACTGANADERIA = "ACTGANADERIA";

    public static final String COLUMN_ACTPESCA = "ACTPESCA";
    public static final String COLUMN_ACTMINERIA = "ACTMINERIA";
    public static final String COLUMN_ACTAPICULTURA = "ACTAPICULTURA";
    public static final String COLUMN_ACTMANUFACTURARTE = "ACTMANUFACTURARTE";

    public static final String COLUMN_ACTSERVPERSONALES = "ACTSERVPERSONALES";
    public static final String COLUMN_ACTCONSTRUCCION = "ACTCONSTRUCCION";
    public static final String COLUMN_ACTEDUCACION = "ACTEDUCACION";
    public static final String COLUMN_ACTTURISMO = "ACTTURISMO";

    public static final String COLUMN_ACTSERVPROF = "ACTSERVPROF";
    public static final String COLUMN_ACTTRANSPORTE = "ACTTRANSPORTE";
    public static final String COLUMN_ACTGOBIERNO = "ACTGOBIERNO";
    public static final String COLUMN_ACTOTRO = "ACTOTRO";

    public static final String COLUMN_ACTEDTOTRO = "ACTEDTOTRO";


    public static final String COLUMN_MATERIAL_VIVIENDA_PAREDES = "VIVPAR";
    public static final String COLUMN_MATERIAL_VIVIENDA_PAREDES_OTRO = "VIVPAROTRO";

    public static final String COLUMN_MATERIAL_VIVIENDA_TECHO = "VIVTECHO";
    public static final String COLUMN_MATERIAL_VIVIENDA_TECHO_OTRO = "VIVTECHOTR";
    public static final String COLUMN_MATERIAL_VIVIENDA_PISO = "VIVPISO";
    public static final String COLUMN_MATERIAL_VIVIENDA_PISO_OTRO = "VIVPISOTR";

    public static final String COLUMN_VIVIENDA_COCINA = "VIVCOCINA";
    public static final String COLUMN_VIVIENDA_CANTIDAD_CUARTOS = "VIVCUARTOS";
    public static final String COLUMN_VIVIENDA_CONTAR_BANIO = "VIVBAN";
    public static final String COLUMN_VIVIENDA_SERVICIO_DRENAJE = "VIVSERVDRE";

    public static final String COLUMN_VIVIENDA_SERVICIO_TELEFONO = "VIVSERVTEL";
    public static final String COLUMN_VIVIENDA_SERVICIO_AGUA = "VIVSERVAGUA";
    public static final String COLUMN_VIVIENDA_SERVICIO_INTERNET = "VIVSERVNET";
    public static final String COLUMN_VIVIENDA_SERVICIO_ELECTRICIDAD = "VIVSERVELE";

    public static final String COLUMN_CANTIDAD_INTEGRANTES_UPF = "FAMNUMINT";
    public static final String COLUMN_PERTENECE_ORGANIZACION = "FAMORGPRO";

    public static final String COLUMN_APOYO_ORGANIZACION_INSUMOS = "APOYINS";
    public static final String COLUMN_APOYO_ORGANIZACION_ASESORIA = "APOYASE";
    public static final String COLUMN_APOYO_ORGANIZACION_FINANCIAMIENTO = "APOYFIN";
    public static final String COLUMN_APOYO_ORGANIZACION_COMERCIALIZACION = "APOYCOM";
    public static final String COLUMN_APOYO_ORGANIZACION_GESTION = "APOYGEST";

    public static final String COLUMN_ORGANIZACION_FINANCIAMIENTO = "FINAN";

    public static final String COLUMN_FINANCIAMIENTO_OTORGABANCO = "OTORGABANCO";
    public static final String COLUMN_FINANCIAMIENTO_OTORGAGOBIERNO = "OTORGAGOBIERNO";
    public static final String COLUMN_FINANCIAMIENTO_OTORGAFINNAC = "OTORGAFINNAC";
    public static final String COLUMN_FINANCIAMIENTO_OTORGAFINRUR = "OTORGAFINRUR";
    public static final String COLUMN_FINANCIAMIENTO_OTORGAFINOTRO = "OTORGAFINOTRO";
    public static final String COLUMN_FINANCIAMIENTO_EDTOTORGFINOTRO = "EDTOTORGFINOTRO";

    public static final String COLUMN_MONTO_FINANCIAMIENTO = "MONTOT";
    public static final String COLUMN_TIPO_SERVICIO_SECTSALUD = "SERVSALUDPSECSAL";
    public static final String COLUMN_TIPO_SERVICIO_SECSOC = "SERVSALUDPSECSOC";

    public static final String COLUMN_TIPO_SERVICIO_OTROSSEC = "SERVSALUDPOTROSEC";
    public static final String COLUMN_TIPO_SERVICIO_PRIVFINLUC = "SERVSALUDPFINLUCRO";
    public static final String COLUMN_TIPO_SERVICIO_PRIVSFINLUCRO = "SERVSALUDPSINFINLUCRO";
    public static final String COLUMN_TIPO_SUFICIENTE_PERSONAL = "SALPERSUF";
    public static final String COLUMN_SATISFACCION_SERVICIO = "SERVSATIS";



    public static final String CREAR_TABLA_PRODUCTOR = "CREATE TABLE " + TABLA_PRODUCTOR +
            "(" +COLUMN_NUMERO_PRODUCTOR +
            " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_FOLIO_ENC +
            " VARCHAR, "+ COLUMN_NUMERO_CAPTURISTA +
            " INTEGER, "+ COLUMN_RESPONSABLEUPF_PRODUCTOR +
            " VARCHAR, "+ COLUMN_PRODUCTOR_RELACION_UPF +
            " VARCHAR, "+ COLUMN_NOMBRE_PRODUCTOR +
            " VARCHAR, "+ COLUMN_APELLIDO_PATERNO_PROD +
            " VARCHAR, "+ COLUMN_APELLIDO_MATERNO_PROD +
            " VARCHAR, "+ COLUMN_SEXO_PROD +
            " VARCHAR, "+ COLUMN_EDAD_PROD +
            " VARCHAR, "+ COLUMN_LEER_PROD +
            " VARCHAR, "+ COLUMN_ESCRIBIR_PROD +
            " VARCHAR, "+ COLUMN_ESTUDIOS_PROD +
            " VARCHAR, "+ COLUMN_SITUACION_ESTUDIOS_PROD +
            " VARCHAR, "+ COLUMN_PUEBLO_ORIGINARIO_PROD +
            " VARCHAR, "+ COLUMN_CUAL_PUEBLO_PROD +
            " VARCHAR, "+ COLUMN_LENGUA_ORIGINARIA_PROD +
            " VARCHAR, "+ COLUMN_CUAL_LENGUA_PROD +

            " VARCHAR, "+ COLUMN_ACTCOMERCIO +
            " VARCHAR, "+ COLUMN_ACTTRANSFORMACION +
            " VARCHAR, "+ COLUMN_ACTAGRICULTURA +
            " VARCHAR, "+ COLUMN_ACTGANADERIA +

            " VARCHAR, "+ COLUMN_ACTPESCA +
            " VARCHAR, "+ COLUMN_ACTMINERIA +
            " VARCHAR, "+ COLUMN_ACTAPICULTURA +
            " VARCHAR, "+ COLUMN_ACTMANUFACTURARTE +

            " VARCHAR, "+ COLUMN_ACTSERVPERSONALES +
            " VARCHAR, "+ COLUMN_ACTCONSTRUCCION +
            " VARCHAR, "+ COLUMN_ACTEDUCACION +
            " VARCHAR, "+ COLUMN_ACTTURISMO +

            " VARCHAR, "+ COLUMN_ACTSERVPROF +
            " VARCHAR, "+ COLUMN_ACTTRANSPORTE +
            " VARCHAR, "+ COLUMN_ACTGOBIERNO +
            " VARCHAR, "+ COLUMN_ACTOTRO +
            " VARCHAR, "+ COLUMN_ACTEDTOTRO +

            " VARCHAR, "+ COLUMN_MATERIAL_VIVIENDA_PAREDES +
            " VARCHAR, "+ COLUMN_MATERIAL_VIVIENDA_PAREDES_OTRO +
            " VARCHAR, "+ COLUMN_MATERIAL_VIVIENDA_TECHO +
            " VARCHAR, "+ COLUMN_MATERIAL_VIVIENDA_TECHO_OTRO +
            " VARCHAR, "+ COLUMN_MATERIAL_VIVIENDA_PISO +
            " VARCHAR, "+ COLUMN_MATERIAL_VIVIENDA_PISO_OTRO +
            " VARCHAR, "+ COLUMN_VIVIENDA_COCINA +
            " VARCHAR, "+ COLUMN_VIVIENDA_CANTIDAD_CUARTOS +
            " VARCHAR, "+ COLUMN_VIVIENDA_CONTAR_BANIO +
            " VARCHAR, "+ COLUMN_VIVIENDA_SERVICIO_DRENAJE +
            " VARCHAR, "+ COLUMN_VIVIENDA_SERVICIO_TELEFONO +
            " VARCHAR, "+ COLUMN_VIVIENDA_SERVICIO_AGUA +
            " VARCHAR, "+ COLUMN_VIVIENDA_SERVICIO_INTERNET +
            " VARCHAR, "+ COLUMN_VIVIENDA_SERVICIO_ELECTRICIDAD +
            " VARCHAR, "+ COLUMN_CANTIDAD_INTEGRANTES_UPF +
            " VARCHAR, "+ COLUMN_PERTENECE_ORGANIZACION +
            " VARCHAR, "+ COLUMN_APOYO_ORGANIZACION_INSUMOS +
            " VARCHAR, "+ COLUMN_APOYO_ORGANIZACION_ASESORIA +
            " VARCHAR, "+ COLUMN_APOYO_ORGANIZACION_FINANCIAMIENTO +
            " VARCHAR, "+ COLUMN_APOYO_ORGANIZACION_COMERCIALIZACION +
            " VARCHAR, "+ COLUMN_APOYO_ORGANIZACION_GESTION +
            " VARCHAR, "+ COLUMN_ORGANIZACION_FINANCIAMIENTO +

            " VARCHAR, "+ COLUMN_FINANCIAMIENTO_OTORGABANCO +
            " VARCHAR, "+ COLUMN_FINANCIAMIENTO_OTORGAGOBIERNO +
            " VARCHAR, "+ COLUMN_FINANCIAMIENTO_OTORGAFINNAC +
            " VARCHAR, "+ COLUMN_FINANCIAMIENTO_OTORGAFINRUR +
            " VARCHAR, "+ COLUMN_FINANCIAMIENTO_OTORGAFINOTRO +
            " VARCHAR, "+ COLUMN_FINANCIAMIENTO_EDTOTORGFINOTRO +

            " VARCHAR, "+ COLUMN_MONTO_FINANCIAMIENTO +
            " VARCHAR, "+ COLUMN_TIPO_SERVICIO_SECTSALUD +
            " VARCHAR, "+ COLUMN_TIPO_SERVICIO_SECSOC +
            " VARCHAR, "+ COLUMN_TIPO_SERVICIO_OTROSSEC +
            " VARCHAR, "+ COLUMN_TIPO_SERVICIO_PRIVFINLUC +
            " VARCHAR, "+ COLUMN_TIPO_SERVICIO_PRIVSFINLUCRO +
            " VARCHAR, "+ COLUMN_TIPO_SUFICIENTE_PERSONAL +
            " VARCHAR, "+ COLUMN_SATISFACCION_SERVICIO +
            " VARCHAR); " ;





    public static final String TABLA_INTEGRANTE_FAMILIA = "TB_FAMILIAPRODUCTOR";

    public static final String COLUMN_ID_INTEGRANTE_FAMILIAR = "IDINT";
    public static final String COLUMN_ID_PRODUCTOR_FAM = "IDPRODUCTOR";
    public static final String COLUMN_FOLIO_ENC_INTEGRANTE = "FOLIO";
    public static final String COLUMN_SEXO_INTEGRANTE = "SEXOINT";
    public static final String COLUMN_EDAD_INTEGRANTE = "EDADINT";
    public static final String COLUMN_LEER_ESCRIBIRINT = "LEINT";
    public static final String COLUMN_NIVEL_ESTUDIOSINT = "NEINT";
    public static final String COLUMN_SITUACION_ESTUDIOSINT = "SNINT";
    public static final String COLUMN_HABLA_LENGUA_ORIGINARIAINT = "LENINT";
    public static final String COLUMN_LENGUA_HABLA_INTEGRANTE = "LENGUA";
    public static final String COLUMN_PARTICIPA_UPF = "ACTUPFI";
    public static final String COLUMN_DEDICA_INTEGRANTE = "DEDINT";
    public static final String COLUMN_INGRESO_MENSUAL_INT = "INGRUPF";
    public static final String COLUMN_OTRO_INGRESO_INT = "OTING";



    public static final String CREAR_TABLA_INTEGRANTE_FAMILIA = "CREATE TABLE " + TABLA_INTEGRANTE_FAMILIA +
            "(" +COLUMN_ID_INTEGRANTE_FAMILIAR +
            " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_ID_PRODUCTOR_FAM +
            " INTEGER, " + COLUMN_FOLIO_ENC_INTEGRANTE +
            " VARCHAR, " + COLUMN_SEXO_INTEGRANTE +
            " VARCHAR, " + COLUMN_EDAD_INTEGRANTE +
            " VARCHAR, " + COLUMN_LEER_ESCRIBIRINT +
            " VARCHAR, " + COLUMN_NIVEL_ESTUDIOSINT +
            " VARCHAR, " + COLUMN_SITUACION_ESTUDIOSINT +
            " VARCHAR, " + COLUMN_HABLA_LENGUA_ORIGINARIAINT +
            " VARCHAR, " + COLUMN_LENGUA_HABLA_INTEGRANTE +
            " VARCHAR, " + COLUMN_PARTICIPA_UPF +
            " VARCHAR, " + COLUMN_DEDICA_INTEGRANTE +
            " VARCHAR, " + COLUMN_INGRESO_MENSUAL_INT +
            " VARCHAR, " + COLUMN_OTRO_INGRESO_INT +
            " VARCHAR); ";


}
