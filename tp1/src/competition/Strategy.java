package competition;

import java.util.List;

public interface Strategy {
	public List<Competitor> selection(List<League> league) throws NumberNotPowerOf2Exception;

}
