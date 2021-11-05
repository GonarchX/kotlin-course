import lab3.*
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class ShapeFactory_CreateShape_Test() {
    companion object {
        val shapeFactory: ShapeFactory = ShapeFactoryImpl()
    }

    //region createCircle Tests

    @Test(expected = IllegalArgumentException::class)
    fun createCircle_inCorrectInstanceCreate() {
        shapeFactory.createCircle(-1.0)
    }
    //endregion

    //region createSquare Tests

    @Test(expected = IllegalArgumentException::class)
    fun createSquare_inCorrectInstanceCreate() {
        shapeFactory.createSquare(-1.0)
    }
    //endregion

    //region createRectangle Tests

    @Test(expected = IllegalArgumentException::class)
    fun createRectangle_inCorrectInstanceCreate_FirstNegativeParameter() {
        shapeFactory.createRectangle(-1.0, 2.0)
    }

    @Test(expected = IllegalArgumentException::class)
    fun createRectangle_inCorrectInstanceCreate_SecondNegativeParameter() {
        shapeFactory.createRectangle(2.0, -1.0)
    }

    @Test(expected = IllegalArgumentException::class)
    fun createRectangle_inCorrectInstanceCreate_AllNegativeParameters() {
        shapeFactory.createRectangle(-1.0, -2.0)
    }
    //endregion

    //region createTriangle Tests

    @Test(expected = IllegalArgumentException::class)
    fun createTriangle_inCorrectInstanceCreate_FisrtSideLarger() {
        shapeFactory.createTriangle(1.0, 2.0, 3.1)
    }

    @Test(expected = IllegalArgumentException::class)
    fun createTriangle_inCorrectInstanceCreate_SecondSideLarger() {
        shapeFactory.createTriangle(1.0, 3.1, 2.0)
    }

    @Test(expected = IllegalArgumentException::class)
    fun createTriangle_inCorrectInstanceCreate_ThirdSideLarger() {
        shapeFactory.createTriangle(3.1, 1.0, 2.0)
    }

    @Test(expected = IllegalArgumentException::class)
    fun createTriangle_inCorrectInstanceCreate_NegativeParameter() {
        shapeFactory.createTriangle(-3.1, 1.0, 2.0)
    }
    //endregion

    //region createRandomCircle Tests

    @Test(expected = IllegalArgumentException::class)
    fun createRandomCircle_NegativeBound() {
        shapeFactory.createRandomCircle(-3.1, 1.0)
    }

    @Test(expected = IllegalArgumentException::class)
    fun createRandomCircle_UpperBoundLessLowerBound() {
        shapeFactory.createRandomCircle(-3.1, 1.0)
    }
    //endregion

    //region createRandomSquare Tests

    @Test(expected = IllegalArgumentException::class)
    fun createRandomSquare_NegativeBound() {
        shapeFactory.createRandomSquare(-3.1, 1.0)
    }

    @Test(expected = IllegalArgumentException::class)
    fun createRandomSquare_UpperBoundLessLowerBound() {
        shapeFactory.createRandomSquare(3.1, 1.0)
    }
    //endregion

    //region createRandomRectangle Tests

    @Test(expected = IllegalArgumentException::class)
    fun createRandomRectangle_NegativeBound() {
        shapeFactory.createRandomRectangle(-3.1, 1.0)
    }

    @Test(expected = IllegalArgumentException::class)
    fun createRandomRectangle_UpperBoundLessLowerBound() {
        shapeFactory.createRandomRectangle(3.1, 1.0)
    }
    //endregion

    //region createRandomTriangle Tests

    @Test(expected = IllegalArgumentException::class)
    fun createRandomTriangle_NegativeBound() {
        shapeFactory.createRandomTriangle(-3.1, 1.0)
    }

    @Test(expected = IllegalArgumentException::class)
    fun createRandomTriangle_UpperBoundLessLowerBound() {
        shapeFactory.createRandomTriangle(3.1, 1.0)
    }
    //endregion

    //region createRandomShape Tests

    @Test(expected = IllegalArgumentException::class)
    fun createRandomShape_NegativeBound() {
        shapeFactory.createRandomShape(-3.1, 1.0)
    }

    @Test(expected = IllegalArgumentException::class)
    fun createRandomShape_UpperBoundLessLowerBound() {
        shapeFactory.createRandomShape(3.1, 1.0)
    }
    //endregion
}

class ShapeFactory_OperationsWithShape_Test() {
    companion object {
        val shapeFactory: ShapeFactory = ShapeFactoryImpl()
        val circle: Circle = shapeFactory.createCircle(5.0)
        val square: Square = shapeFactory.createSquare(3.0)
        val rectangle: Rectangle = shapeFactory.createRectangle(3.0, 10.0)
        val triangle: Triangle = shapeFactory.createTriangle(4.0, 3.0, 5.0)
    }

    //region Circle_calcArea
    @Test
    fun Circle_calcArea_CorrectResult(){
        assertEquals(circle.calcArea(), 15.707963267948966)
    }

    @Test
    fun Circle_calcArea_IncorrectResult(){
        assertNotEquals(circle.calcArea(), 5.0)
    }

    @Test
    fun Circle_calcPerimeter_CorrectResult(){
        assertEquals(circle.calcPerimeter(), 31.41592653589793)
    }

    @Test
    fun Circle_calcPerimeter_IncorrectResult(){
        assertNotEquals(circle.calcPerimeter(), 3.0)
    }

    //endregion

    //region Square_calcArea
    @Test
    fun Square_calcArea_CorrectResult(){
        assertEquals(square.calcArea(), 9.0)
    }

    @Test
    fun Square_calcArea_IncorrectResult(){
        assertNotEquals(square.calcArea(), 5.0)
    }

    @Test
    fun Square_calcPerimeter_CorrectResult(){
        assertEquals(square.calcPerimeter(), 12.0)
    }

    @Test
    fun Square_calcPerimeter_IncorrectResult(){
        assertNotEquals(square.calcPerimeter(), 5.0)
    }

    //endregion

    //region Rectangle_calcArea
    @Test
    fun Rectangle_calcArea_CorrectResult(){
        assertEquals(rectangle.calcArea(), 30.0)
    }

    @Test
    fun Rectangle_calcArea_IncorrectResult(){
        assertNotEquals(rectangle.calcArea(), 5.0)
    }

    @Test
    fun Rectangle_calcPerimeter_CorrectResult(){
        assertEquals(rectangle.calcPerimeter(), 26.0)
    }

    @Test
    fun Rectangle_calcPerimeter_IncorrectResult(){
        assertNotEquals(rectangle.calcPerimeter(), 5.0)
    }

    //endregion

    //region Triangle_calcArea
    @Test
    fun Triangle_calcArea_CorrectResult(){
        assertEquals(triangle.calcArea(), 6.0)
    }

    @Test
    fun Triangle_calcArea_IncorrectResult(){
        assertNotEquals(triangle.calcArea(), 5.0)
    }

    @Test
    fun Triangle_calcPerimeter_CorrectResult(){
        assertEquals(triangle.calcPerimeter(), 12.0)
    }

    @Test
    fun Triangle_calcPerimeter_IncorrectResult(){
        assertNotEquals(triangle.calcPerimeter(), 5.0)
    }

    //endregion
}