public class Team {
    final private int CODIGO;
    private String nome;
    private int wins;
    private int losses;
    private int withdraws;
    private int goals;
    private int goalsTaken;
    public Team(int codigo, String nome){
        this.CODIGO = codigo;
        this.nome = nome;
        this.wins = 0;
        this.losses = 0;
        this.withdraws = 0;
        this.goals = 0;
        this.goalsTaken = 0;
    }

    // Getters
    public int getCODIGO(){
        return this.CODIGO;
    }

    public String getNome(){
        return this.nome;
    }



    // Setters
    public void setNome(String nome){
        this.nome = nome;
    }

    public void addWithdraw(){
        this.withdraws++;
    }

    public void addGoals(int goals){
        this.goals += goals;
    }

    public void addGoalsTaken(int goalsTaken){
        this.goalsTaken += goalsTaken;
    }

    public void addWin(){
        this.wins++;
    }

    public void addLoss(){
        this.losses++;
    }
}
