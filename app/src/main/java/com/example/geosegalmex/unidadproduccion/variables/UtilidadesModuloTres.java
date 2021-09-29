package com.example.geosegalmex.unidadproduccion.variables;

public class UtilidadesModuloTres {
    public static final String TABLA_UPF = "TbUPF";
    public static final	String COLUMN_IDUPF	= "IDUPF";	//	int
    public static final	String COLUMN_FOLIO	= "FOLIO";	//	String
    public static final	String COLUMN_IDCAPTURIS	= "IDCAPTURIS";	//	int
    public static final	String COLUMN_ESTADOUPF	= "ESTADOUPF";	//	String
    public static final	String COLUMN_CVEEDOUPF	= "CVEEDOUPF";	//	int
    public static final	String COLUMN_MUNPRUPF	= "MUNPRUPF";	//	String
    public static final	String COLUMN_CVEMUNUPF	= "CVEMUNUPF";	//	int
    public static final	String COLUMN_LOCPRUPF	= "LOCPRUPF";	//	String
    public static final	String COLUMN_NOMUPF	= "NOMUPF";	//	String
    public static final	String COLUMN_SUPUPF	= "SUPUPF";	//	int
    public static final	String COLUMN_PRODFORM	= "PRODFORM";	//	int
    public static final	String COLUMN_PRODFORNM	= "PRODFORNM";	//	int
    public static final	String COLUMN_PRODFORPM	= "PRODFORPM";	//	int
    public static final	String COLUMN_PRODFOROT	= "PRODFOROT";	//	int
    public static final	String COLUMN_PRODFOROTACT	= "PRDFOROTAC";	//	int Otro Edit
    public static final	String COLUMN_PCOMID	= "PCOMID";	//	String
    public static final	String COLUMN_PSINCOMID	= "PSINCOMID";	//	String
    public static final	String COLUMN_ALISAVA	= "ALISAVA";	//	String
    public static final	String COLUMN_ALITOR	= "ALITOR";	//	int
    public static final	String COLUMN_ALIPAP	= "ALIPAP";	//	int
    public static final	String COLUMN_ALIVER	= "ALIVER";	//	int
    public static final	String COLUMN_ALIFRU	= "ALIFRU";	//	int
    public static final	String COLUMN_ALICAR	= "ALICAR";	//	int
    public static final	String COLUMN_ALIHUE	= "ALIHUE";	//	int
    public static final	String COLUMN_ALIPES	= "ALIPES";	//	int
    public static final	String COLUMN_ALIFLH	= "ALIFLH";	//	int
    public static final	String COLUMN_ALIQUE	= "ALIQUE";	//	int
    public static final	String COLUMN_ALIACE	= "ALIACE";	//	int
    public static final	String COLUMN_ALIAZU	= "ALIAZU";	//	int
    public static final	String COLUMN_ALICON	= "ALICON";	//	int

    //public static final	String COLUMN_ALICOMP	= "ALICOMP";	//	String
    //Agregados despues
    public static final	String COLUMN_ALICOMPFrutas= "ALICOMPFrs";	//	Text add bd
    public static final	String COLUMN_ALICOMPHortalizas= "ALICOMPHrs";	//	Text add bd
    public static final	String COLUMN_ALICOMPGranos= "ALICOMPGrs";	//	Text add bd
    public static final	String COLUMN_ALICOMPCarne= "ALICOMPCrn";	//	Text add bd
    public static final	String COLUMN_ALICOMPLeche= "ALICOMPLch";	//	Text add bd


    public static final	String COLUMN_ALICOMPNEC	= "ALICOMPNEC";	//	String

    //public static final	String COLUMN_DOCOMP	= "DOCOMP";	//	String
    public static final	String COLUMN_DOCOMPDirectoPro = "DOCOMPDrPr";	//	Text add bd
    public static final	String COLUMN_DOCOMPMercLocal	= "DOCOMPMLc";	//	Text add bd
    public static final	String COLUMN_DOCOMPMercMun	= "DOCOMPMrcM";	//	Text add bd
    public static final	String COLUMN_DOCOMPInds	= "DOCOMPInd";	//	Text add bd


    public static final	String COLUMN_TENTIE	= "TENTIE";	//	String
    public static final	String COLUMN_TENTIEOT	= "TENTIEOT";	//	String
    public static final	String COLUMN_TIPPROP	= "TIPPROP";	//	String
    public static final	String COLUMN_PENDPAR	= "PENDPAR";	//	String
    public static final	String COLUMN_ASESORIA	= "ASESORIA";	//	String
    public static final	String COLUMN_ASESORIAO	= "ASESORIAO";	//	String
    public static final	String COLUMN_DINACTPRO	= "DINACTPRO";	//	String
    public static final	String COLUMN_ASISTEC	= "ASISTEC";	//	int

    public static final	String COLUMN_ASISTECDO	= "ASISTECDO";	//	String
    public static final	String COLUMN_ASISTECDOtro	= "ASISTECDOt";	//	String


    public static final	String COLUMN_DIFMAQ	= "DIFMAQ";	//	String
    public static final	String COLUMN_SACTAGRIRI	= "SACTAGRIRI";	//	int
    public static final	String COLUMN_SACTPECRI	= "SACTPECRI";	//	int
    public static final	String COLUMN_SACTAGRITE	= "SACTAGRITE";	//	int
    public static final	String COLUMN_SACTPECTE	= "SACTPECTE";	//	int
    public static final	String COLUMN_SUPPAS	= "SUPPAS";	//	String

    public static final String CREAR_TABLA_UPF = "CREATE TABLE " + TABLA_UPF +
            "(" + COLUMN_IDUPF +
            " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_FOLIO +
            " VARCHAR, " +  COLUMN_IDCAPTURIS	+		//	int
            " VARCHAR, " +  COLUMN_ESTADOUPF	+		//	String
            " VARCHAR, " +  COLUMN_CVEEDOUPF	+		//	int
            " VARCHAR, " +  COLUMN_MUNPRUPF	+		//	String
            " VARCHAR, " +  COLUMN_CVEMUNUPF	+		//	int
            " VARCHAR, " +  COLUMN_LOCPRUPF	+		//	String
            " VARCHAR, " +  COLUMN_NOMUPF	+		//	String
            " VARCHAR, " +  COLUMN_SUPUPF	+		//	int
            " VARCHAR, " +  COLUMN_PRODFORM	+		//	int
            " VARCHAR, " +  COLUMN_PRODFORNM	+		//	int
            " VARCHAR, " +  COLUMN_PRODFORPM	+		//	int
            " VARCHAR, " +  COLUMN_PRODFOROT	+		//	int
            " VARCHAR, " +  COLUMN_PRODFOROTACT	+		//	int otra actividad forestal
            " VARCHAR, " +  COLUMN_PCOMID	+		//	String
            " VARCHAR, " +  COLUMN_PSINCOMID	+		//	String
            " VARCHAR, " +  COLUMN_ALISAVA	+		//	String
            " VARCHAR, " +  COLUMN_ALITOR	+		//	int
            " VARCHAR, " +  COLUMN_ALIPAP	+		//	int
            " VARCHAR, " +  COLUMN_ALIVER	+		//	int
            " VARCHAR, " +  COLUMN_ALIFRU	+		//	int
            " VARCHAR, " +  COLUMN_ALICAR	+		//	int
            " VARCHAR, " +  COLUMN_ALIHUE	+		//	int
            " VARCHAR, " +  COLUMN_ALIPES	+		//	int
            " VARCHAR, " +  COLUMN_ALIFLH	+		//	int
            " VARCHAR, " +  COLUMN_ALIQUE	+		//	int
            " VARCHAR, " +  COLUMN_ALIACE	+		//	int
            " VARCHAR, " +  COLUMN_ALIAZU	+		//	int
            " VARCHAR, " +  COLUMN_ALICON	+		//	int
            " VARCHAR, " +  COLUMN_ALICOMPFrutas	+		//	String
            " VARCHAR, " +  COLUMN_ALICOMPHortalizas	+		//	String
            " VARCHAR, " +  COLUMN_ALICOMPGranos	+		//	String
            " VARCHAR, " +  COLUMN_ALICOMPCarne	+		//	String
            " VARCHAR, " +  COLUMN_ALICOMPLeche	+		//	String
            " VARCHAR, " +  COLUMN_ALICOMPNEC	+		//	String
            " VARCHAR, " +  COLUMN_DOCOMPDirectoPro	+		//	String
            " VARCHAR, " +  COLUMN_DOCOMPMercLocal	+		//	String
            " VARCHAR, " +  COLUMN_DOCOMPMercMun	+		//	String
            " VARCHAR, " +  COLUMN_DOCOMPInds	+		//	String
            " VARCHAR, " +  COLUMN_TENTIE	+		//	String
            " VARCHAR, " +  COLUMN_TENTIEOT	+		//	String
            " VARCHAR, " +  COLUMN_TIPPROP	+		//	String
            " VARCHAR, " +  COLUMN_PENDPAR	+		//	String
            " VARCHAR, " +  COLUMN_ASESORIA	+		//	String
            " VARCHAR, " +  COLUMN_ASESORIAO	+		//	String
            " VARCHAR, " +  COLUMN_DINACTPRO	+		//	String
            " VARCHAR, " +  COLUMN_ASISTEC	+		//	int
            " VARCHAR, " +  COLUMN_ASISTECDO	+		//	String
            " VARCHAR, " +  COLUMN_ASISTECDOtro	+		//	String
            " VARCHAR, " +  COLUMN_DIFMAQ	+		//	String
            " VARCHAR, " +  COLUMN_SACTAGRIRI	+		//	int
            " VARCHAR, " +  COLUMN_SACTPECRI	+		//	int
            " VARCHAR, " +  COLUMN_SACTAGRITE	+		//	int
            " VARCHAR, " +  COLUMN_SACTPECTE	+		//	int
            " VARCHAR, " +  COLUMN_SUPPAS	+		//	String
            " VARCHAR);";


    //+++++++++++++++++++++++++++AGRICOLA++++++++++++++++++++++++++++++++++++++++++++++

    public static final String TABLA_PROD_AGRICOLA = "TbUPFPAGR";
    public static final	String COLUMN_IDPROAGRI	= "IDPROAGRI";	//	int
    //public static final	String COLUMN_FOLIO	= "FOLIO";	//	String
    public static final	String COLUMN_PRODUAGRI	= "PRODUAGRI";	//	String
    public static final	String COLUMN_PRODSUPERF	= "PRODSUPERF";	//	int

    public static final String CREAR_TABLA_AGRICOLA = "CREATE TABLE " + TABLA_PROD_AGRICOLA +
            "(" + COLUMN_IDPROAGRI +
            " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_IDUPF +
            " VARCHAR, " +  COLUMN_FOLIO	+		//	String
            " VARCHAR, " +  COLUMN_IDCAPTURIS	+		//	int
            " VARCHAR, " +  COLUMN_PRODUAGRI	+		//	String
            " VARCHAR, " +  COLUMN_PRODSUPERF	+		//	int
            " VARCHAR);";

    //+++++++++++++++++++++++++++PECUARIA++++++++++++++++++++++++++++++++++++++++++++++
    public static final String TABLA_PROD_PECUARIA = "TbUPFPPEC";
    public static final	String COLUMN_IDPRODPEC	= "IDPRODPEC";	//	int
    //public static final	String COLUMN_FOLIO	= "FOLIO";	//	String
    public static final	String COLUMN_ESPECIEPEC	= "ESPECIEPEC";	//	String
    public static final	String COLUMN_CABZCOL	= "CABZCOL";	//	int
    public static final	String COLUMN_PRODCARNE	= "PRODCARNE";	//	String
    public static final	String COLUMN_PRODLECHE	= "PRODLECHE";	//	String
    public static final	String COLUMN_PRODLECH	= "PRODLECH";	//	String
    public static final	String COLUMN_PRODHUEVO	= "PRODHUEVO";	//	String
    public static final	String COLUMN_PRODLANA	= "PRODLANA";	//	String
    public static final	String COLUMN_PRODPIEL	= "PRODPIEL";	//	String
    public static final	String COLUMN_PRODPIE	= "PRODPIE";	//	String
    public static final	String COLUMN_PRODPOLLIT	= "PRODPOLLIT";	//	String
    public static final	String COLUMN_PRODMIEL	= "PRODMIEL";	//	String
    public static final	String COLUMN_PRODREINA	= "PRODREINA";	//	String
    public static final	String COLUMN_PRODJALEA	= "PRODJALEA";	//	String
    public static final	String COLUMN_PRODCERA	= "PRODCERA";	//	String
    public static final	String COLUMN_PRODPOLEN	= "PRODPOLEN";	//	String
    public static final	String COLUMN_PRODNUCLEO	= "PRODNUCLEO";	//	String
    public static final	String COLUMN_PRODPROP	= "PRODPROP";	//	String

    public static final String CREAR_TABLA_PECUARIA = "CREATE TABLE " + TABLA_PROD_PECUARIA +
            "(" + COLUMN_IDPRODPEC +
            " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_FOLIO +
            " VARCHAR, " +  COLUMN_IDCAPTURIS	+		//	int
            " VARCHAR, " +  COLUMN_ESPECIEPEC	+		//	String
            " VARCHAR, " +  COLUMN_CABZCOL	+		//	int
            " VARCHAR, " +  COLUMN_PRODCARNE	+		//	String
            " VARCHAR, " +  COLUMN_PRODLECHE	+		//	String
            " VARCHAR, " +  COLUMN_PRODLECH	+		//	String
            " VARCHAR, " +  COLUMN_PRODHUEVO	+		//	String
            " VARCHAR, " +  COLUMN_PRODLANA	+		//	String
            " VARCHAR, " +  COLUMN_PRODPIEL	+		//	String
            " VARCHAR, " +  COLUMN_PRODPIE	+		//	String
            " VARCHAR, " +  COLUMN_PRODPOLLIT	+		//	String
            " VARCHAR, " +  COLUMN_PRODMIEL	+		//	String
            " VARCHAR, " +  COLUMN_PRODREINA	+		//	String
            " VARCHAR, " +  COLUMN_PRODJALEA	+		//	String
            " VARCHAR, " +  COLUMN_PRODCERA	+		//	String
            " VARCHAR, " +  COLUMN_PRODPOLEN	+		//	String
            " VARCHAR, " +  COLUMN_PRODNUCLEO	+		//	String
            " VARCHAR, " +  COLUMN_PRODPROP	+		//	String
            " VARCHAR);";



    //+++++++++++++++++++++++++++ACUICOLA++++++++++++++++++++++++++++++++++++++++++++++
    public static final String TABLA_PROD_ACUICOLA = "TbUPFPACU";
    public static final	String COLUMN_IDPRODACUI	= "IDPRODACUI";	//	int
    //public static final	String COLUMN_FOLIO	= "FOLIO";	//	String
    public static final	String COLUMN_ESPECIEPECui	= "ESPCICACUI";	//	String
    public static final	String COLUMN_OTRACTIAC	= "OTRACTIAC";	//	Stringo
    public static final	String COLUMN_SUPACAC	= "SUPACAC";	//	int
    public static final	String COLUMN_ACUNE	= "ACUNE";	//	int
    public static final	String COLUMN_ACUVT	= "ACUVT";	//	int


    public static final String CREAR_TABLA_ACUICOLA = "CREATE TABLE " + TABLA_PROD_ACUICOLA +
            "(" + COLUMN_IDPRODACUI +
            " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_FOLIO +
            " VARCHAR, " +  COLUMN_IDCAPTURIS	+		//	int
            " VARCHAR, " +  COLUMN_ESPECIEPECui	+		//	String
            " VARCHAR, " +  COLUMN_OTRACTIAC	+		//	String
            " VARCHAR, " +  COLUMN_SUPACAC	+		//	int
            " VARCHAR, " +  COLUMN_ACUNE	+		//	int
            " VARCHAR, " +  COLUMN_ACUVT	+		//	int
            " VARCHAR);";


    //+++++++++++++++++++++++++++FUENTE_AGUA++++++++++++++++++++++++++++++++++++++++++++++
    public static final String TABLA_FUENTE_AGUA = "TbUPFFAG";
    public static final	String COLUMN_IDFDAGUA	= "IDFDAGUA";	//	int
    //public static final	String COLUMN_FOLIO	= "FOLIO";	//	String
    public static final	String COLUMN_FDAGUA	= "FDAGUA";	//	String
    public static final	String COLUMN_PAAGUA	= "PAAGUA";	//	String
    public static final	String COLUMN_PAAGUAPA	= "PAAGUAPA";	//	String
    public static final	String COLUMN_PAAGUACO	= "PAAGUACO";	//	String

    public static final String CREAR_TABLA_FUENTEAGUA = "CREATE TABLE " + TABLA_FUENTE_AGUA +
            "(" + COLUMN_IDFDAGUA +
            " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_FOLIO +
            " VARCHAR, " +  COLUMN_IDCAPTURIS	+		//	int
            " VARCHAR, " +  COLUMN_FDAGUA	+		//	String
            " VARCHAR, " +  COLUMN_PAAGUA	+		//	String
            " VARCHAR, " +  COLUMN_PAAGUAPA	+		//	String
            " VARCHAR, " +  COLUMN_PAAGUACO	+		//	String
            " VARCHAR);";
}
