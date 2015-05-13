package nmct.howest.be.bmi;

/**
 * Created by BrechtCaveye on 9/04/2015.
 */
public class BMIInfo {
    public float height = 1.70f;
    public int mass = 70;
    public float bmiIndex;

    public int getMass() {
        return mass;
    }

    public void setMass(int mass) {
        this.mass = mass;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setBmiIndex(float bmiIndex) {
        this.bmiIndex = bmiIndex;
    }

    public BMIInfo(float Height, int Mass)
    {
        this.height = Height;
        this.mass = Mass;
    }
    public static float recalculate(float height, int mass)
    {
        float result = mass/(height*height);
        return result;
    }
    public enum Category
    {
        Groot_Ondergewicht (0f, 15f),
        Ernstig_ondergewicht (15f, 16f),
        Ondergewicht (16f, 18.5f),
        Normaal (18.5f, 25f),
        Overgewicht (25f, 30f),
        Matig_Overgewicht(30f, 35f),
        Ernstig_overgewicht(25f, 40f),
        Zeer_groot_overgewicht(40f, 100f);

        private final  float lowerBoundary;
        private final  float upperBoundary;

        Category(float lowerBoundary, float upperBoundary) {
            this.lowerBoundary = lowerBoundary;
            this.upperBoundary = upperBoundary;
        }

        public float getLowerBoundary() {
            return lowerBoundary;
        }

        public float getUpperBoundary() {
            return upperBoundary;
        }
        public boolean isInBoundary(float par)
        {
            return par > lowerBoundary && par <= upperBoundary;
        }
        public static Category getGategory(float index)
        {
            for(Category  category: Category.values()){
                if(category.isInBoundary(index))
                    return category;
            }
            return  null;
        }
    }
}
