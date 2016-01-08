
/**
 * Write a description of class alimentos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class alimentos
{
    // declaramos las variables :proteinas carbohidratos y grasas
    private String nombre;
    private float proteinas;
    private float  carbo;
    private float grasas;
    private float calorias;
    private String mayorValor;
   

    /**
     * Constructor for objects of class alimentos
     */
    public alimentos(String nombre,float proteinas,float carbo, float grasas)
    {
        // initialise instance variables
        this.nombre = nombre;
        this.proteinas = proteinas;
        this.carbo = carbo;
        this.grasas = grasas;
      
      
    
    }
    /**
      * Metodo para calcular calorias
      */
      
    public float valorcalorias()
    {
        
        calorias = (proteinas*4) + (carbo*4) + (grasas*9);
        return calorias;
    }
    

    
    /**
     *Metodo para imprimir por pantalla
     */
    public void mostrarDatos()
    {
         System.out.println ("Nombre                           :" +  nombre ) ;
        System.out.println ("Proteínas por cada 100 gramos     :" +  proteinas ) ;
        System.out.println ("Carbohidratos por cada 100 gramos :" +  carbo ) ;
        System.out.println ("Grasas por cada 100 gramos        :"+  grasas ) ;
        if (proteinas >=0 && proteinas<=100 && carbo>=0&& carbo<=100 && grasas>=0 && grasas <=100)
        {

            if (proteinas > carbo && proteinas > grasas)
            {
                mayorValor =  " proteinas";
            }
            else if (carbo > proteinas && carbo > grasas)
            {
               mayorValor = "carbohidratos" ;
            }
            else if(grasas > carbo && grasas > proteinas)
            {
                mayorValor =  "grasas";
            }
            else if(proteinas == carbo && proteinas != grasas && proteinas > grasas )
            {
                mayorValor =  "proteínas y carbohidratos";
            }
            else if(proteinas == grasas && proteinas != carbo && proteinas > carbo )
            {
                mayorValor =  "proteínas y grasas";
            }
            else if(carbo == grasas && proteinas != carbo && proteinas <carbo )
            {
                mayorValor =  "carbohidratos y grasas";
            }
        }
        else
        {
            System.out.println ("El macronutriente no es válido "  ) ;
        }
        System.out.println ("El macronutriente mayoritario es  " +  mayorValor ) ;
        calorias = (proteinas*4) + (carbo*4) + (grasas*9);
        System.out.println ("Las calorias totales son  " +  calorias ) ;
    }
}

      

