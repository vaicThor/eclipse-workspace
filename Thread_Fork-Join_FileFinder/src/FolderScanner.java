import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class FolderScanner extends RecursiveTask<Long> {
	
	private Path path;
	private String filter = "*";
	private long result = 0 ;
	
	public FolderScanner() {}
	public FolderScanner(Path p, String f) {
		path = p;
		filter = f;
	}
	
	/**
	 * Méthode qui se charge de scanner les dossiers de façon récursive
	 * @throws ScanException
	 */
	public long sequentialScan() throws ScanException{
		//Si le chemin n'est pas valide, on lève une exception
		if(path==null || path.equals(""))
			throw new ScanException("Chemin à scanner non valide");
		
		System.out.println("Scan du dossier : "+path+" à la recherche des fichiers portant l'extension "+this.filter);
		
		//On liste maintenatn le contenu du repertoire pour traiter les sous-dossier
		try(DirectoryStream<Path> listing = Files.newDirectoryStream(path)){
			for(Path nom : listing) {
				//S'il s'agit d'un dossier, on le scanne grâce à notre objet
				if (Files.isDirectory(nom.toAbsolutePath())) {
					FolderScanner f = new FolderScanner(nom.toAbsolutePath(),this.filter);
					result += f.sequentialScan();
				}
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
		//Maintenant, on filtre le contenu de ce même dossier sur le filtre defini
		try(DirectoryStream<Path> listing = Files.newDirectoryStream(path, this.filter)){
			for(Path nom : listing) {
				result++;
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public long parallelScan() throws ScanException{
	//Liste des objets qui contiendra les sous-tâches créées et lancées
		List<FolderScanner> list = new ArrayList<>();
	
	// Si le chemin n'est pas valide 
		if(path == null || path.equals(""))
			throw new ScanException("Chemin à scanner non valide");
		
		System.out.println("Scan du dossier : "+path+" à la recherche des fichiers portant l'extension "+this.filter);
	
		try(DirectoryStream<Path> listing = Files.newDirectoryStream(path)){
			for(Path nom : listing) {
				//S'il s'agit d'un dossier on créé une sous-tâche.
				if(Files.isDirectory(nom.toAbsolutePath())) {
					//Nous créons donc un nouvel objet FolderScanner
					//qui se chargera de scanner ce dossier
					FolderScanner f = new FolderScanner(nom.toAbsolutePath(),this.filter);
					//Nous l'ajoutons à la liste des tâches en cours pour récuperer le résultat plus tard
					list.add(f);
					//C'est cett instruction qui lance l'action en tâche de fond
					f.fork();
				}
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
		//#########################################################################"
		// On compte maintenant les fichiers, correspondant au filtre, présent dans ce dossier
		
		try(DirectoryStream<Path> listing = Files.newDirectoryStream(path)){
			for(Path nom : listing) {
				result++;
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		for(FolderScanner f : list)
			result=+f.join();

		return result;
	}
	
	@Override
	protected Long compute() {
		long resultat = 0;
		
		try {
			resultat = this.parallelScan();
			}catch(ScanException s) {
				s.printStackTrace();}
		
		return resultat;
	}

	public long getResultat() {return this.result;}
}
