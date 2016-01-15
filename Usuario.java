import java.util.ArrayList;
/**
 * Write a description of class Usuario here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Usuario
{
    //nombre del usuario
    private String nombreCompleto;
    //proteinas  ingeridas por el usuario
    private float proteinasIngeridas;
    //carbohidratos   ingeridas por el usuario
    private float carbohidratosIngeridos;
    //grasas ingeridas por el usuario
    private float grasasIngeridas;
    //calorias totales ingeridas por el usuario
    private float caloriasIngeridas;
    //Guarda el alimento mas calorico ingerido hasta el momento
    private Alimento alimentoMasCalorico;
    //lista de alimentos ingeridos
    private ArrayList<Alimento>alimentoElegido;

    /**
    *Constructor de la clase usuario
    */
    public Usuario (String nombreCompleto)
    {
        this.nombreCompleto = nombreCompleto;   
        proteinasIngeridas = 0;
        carbohidratosIngeridos = 0;
        grasasIngeridas = 0;
        caloriasIngeridas = 0;
        alimentoMasCalorico = null;
        alimentoElegido = new ArrayList<Alimento>();
       
    }
    
    /**
    * Metodo utilizado para dar de comer al usuario
    */
    public void comer(Alimento alimentoQueCome, float gramosDelAlimento)
    {
        proteinasIngeridas = proteinasIngeridas + (alimentoQueCome.getProteinas() / 100 * gramosDelAlimento);
        carbohidratosIngeridos = carbohidratosIngeridos + (alimentoQueCome.getCarbohidratos() / 100 * gramosDelAlimento);
        grasasIngeridas = grasasIngeridas + (alimentoQueCome.getGrasas() / 100 * gramosDelAlimento);
        caloriasIngeridas = caloriasIngeridas + (alimentoQueCome.getCalorias() / 100 * gramosDelAlimento);
        
        //Si el alimento que se esta comiendo es mas calorico que
        //el que teniamos guardado, entonces tenemos que guardar ese alimento como
        //más calorico. Si no hemos comido ningun alimento entonces el alimento
        //que nos estamos comiendo es el más calorico

        if (alimentoMasCalorico != null) {
            if (alimentoQueCome.getCalorias() >= alimentoMasCalorico.getCalorias()) {
                alimentoMasCalorico = alimentoQueCome;
            }
        }
        else {
            alimentoMasCalorico = alimentoQueCome;
        }
       
        alimentoElegido.add(alimentoQueCome);
    }
    
   
    /**
     * Muestra por pantalla el alimento más calorico ingerido hasta el momento y 
     * sus calorias
     */
    public void alimentoMasCaloricoConsumido()
    {
        if (alimentoMasCalorico == null) {
            System.out.println("No has consumido ningun alimento");
        }
        else {
            System.out.println("El alimento mas calorico es: " + alimentoMasCalorico.getNombre() +
                   "(" + alimentoMasCalorico.getCalorias() + ")");
          }
    }
    
    /**
     * Metodo que muestra por pantalla el alimentos q se quiera de los que haya ingerido
     */
    
    public void mustraAlimentoElegido(int index)
    {
        Alimento alimentoQueCome = alimentoElegido.get(index);
        alimentoQueCome.muestraDatos();
    }
    
    /**
    * Metodo que muestra la informacion de lo ingerido por el usuario.
    */
    public void muestraDatos()
    {
        float totalNutrientes = (proteinasIngeridas + grasasIngeridas + carbohidratosIngeridos) / 100;
            String datosProteinas = "Gramos totales de proteinas ingeridos:     " + proteinasIngeridas;
            String datosCarbohidratos = "Gramos totales de carbohidratos ingeridos: " +             carbohidratosIngeridos;
            String datosGrasas = "Gramos totales de grasas ingeridos:        " + grasasIngeridas;
            if (proteinasIngeridas > 0) {
                datosProteinas = datosProteinas + " (" + proteinasIngeridas / totalNutrientes + "%)";
            }
            if (carbohidratosIngeridos > 0) {
                datosCarbohidratos = datosCarbohidratos + " (" + carbohidratosIngeridos / totalNutrientes + "%      )";
            }
            if (grasasIngeridas > 0) {
                datosGrasas = datosGrasas + " (" + grasasIngeridas / totalNutrientes + "%)";
            }
            System.out.println("Nombre:                                    " + nombreCompleto);
            System.out.println(datosProteinas);    
            System.out.println(datosCarbohidratos);
            System.out.println(datosGrasas);
            System.out.println("Calorias totales ingeridas:                " + caloriasIngeridas);  
        }
}