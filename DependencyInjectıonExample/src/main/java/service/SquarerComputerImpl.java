package service;


//Servisi aınıfı,eğer yeni birşey eklemek istersem Icomputeri implement edip çağırabilirim.
public class SquarerComputerImpl implements IComputer {
    public long compute(long computeNumber) {
        return computeNumber * computeNumber;
    }
}
