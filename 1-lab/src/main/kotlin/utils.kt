fun alignText(
    text: String,
    alignment: Alignment = Alignment.LEFT,
    lineWidth: Int = 120
): String
{
    when(alignment)
    {
        Alignment.LEFT    -> println("You choose LEFT alignment")
        Alignment.RIGHT   -> println("You choose RIGHT alignment")
        Alignment.CENTER  -> println("You choose CENTER alignment")
        Alignment.JUSTIFY -> println("You choose JUSTIFY alignment")
    }

    return "a";
// code here
}

