public class Data_Structure_Stack_USING_AN_ARRAY {
    private int top; // pointer
    private int[] array;

    public Data_Structure_Stack_USING_AN_ARRAY(int capacity)
    {
        this.top = -1;
        array = new int[capacity];
    }

    /******
     * This method checks if the stack is full or not
     * @return
     */
    public boolean stack_is_full()
    {
        return top == array.length - 1;
    }

    /*****
     * Checks if the stack is empty or not
     * @return
     */
    public boolean stack_is_empty()
    {
        return top < 0;
    }

    /****
     * This method basically is to point the right value for the top
     * According to the stack algorithm
     * @param value
     */
    public void push(int value)
    {
        if(stack_is_full()) throw new RuntimeException("Stack is motherfucking full!!");
        top++;
        array[top] = value;
    }

    /******
     * This method will return and delete the top element in the stack
     * @return
     */
    public int pop()
    {
        if (stack_is_empty()) throw new RuntimeException("Stack is motherfucking empty!!");
        int result = array[top];
        top--;
        return result;
    }


    /******
     * This method just returns the top value and also checks if the stack is empty or not
     * @return
     */
    public int peek()
    {
        if(stack_is_empty()) throw new RuntimeException("Stack is empty");

        return array[top];
    }
    public int size()
    {
        return top+1;
    }

    public static void main(String[] args) {
        Data_Structure_Stack_USING_AN_ARRAY stack = new Data_Structure_Stack_USING_AN_ARRAY(3);

        stack.push(3);
        stack.push(4);
        stack.push(5);
//        stack.push(7);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        System.out.println(stack.size());
        System.out.println(stack.array[stack.top]);
    }
}
