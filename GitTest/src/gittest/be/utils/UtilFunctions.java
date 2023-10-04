/**
 * 
 */
package be.phpeeters.iptv.gest.utils;

import java.math.BigInteger;

/**
 * @author Philippe_Portable
 *
 */
public class UtilFunctions {
	
	
	public static String generateStructuredCommunication(int iTransactionID) {
		final BigInteger BIG_97 = BigInteger.valueOf(97);
		 
		BigInteger numRIB = new BigInteger("...");
		long cleRIB = 97 - numRIB.remainder(BIG_97).longValue();
		  String sControl = bcmod(iTransactionID, 97); 

		  $control = ($control == "0") ? "97" : $control;
		  
		  if ($control < 10) {
		    $control = "0" . $control;
		  }
		  
		  $count = 10 - strlen($transactionID);
		  
		  for ($i=0; $i < $count; $i++) {
		    $transactionID = "0" . $transactionID;
		  }
		  
		  $com = $transactionID . $control;
		  
		  return substr($com, 0, 3) . "/" . substr($com, 3, 4) . "/" . substr($com, 7, 5);
	}



	public static String convertitNombreEnLettres(int iNombreAConvertir) {
		$tablePuissancesDeDix = array("", "mille", "millions", "milliards");// ce qu'on affichera apres chaque serie de trois
		$tableConversionEtapeDeux = array("", "dix", "vingt", "trente", "quarante", "cinquante", "soixante", "septante", "quatre-vingt", "nonente");// equivalent du second chiffre de la serie de 3 (la dizaine)
		$tableConversionEtapeUnOuTrois = array("", "un", "deux", "trois", "quatre", "cinq", "six", "sept", "huit", "neuf");// equivalent du premier et du troisieme chiffre de la serie de 3
		$tableConversionDeLaDizaineQuiFaitChier = array("", "onze", "douze", "treize", "quatorze", "quinze", "seize");
		$nombreAConvertir = number_format($nombreAConvertir);// on formate le nombre "a l'anglaise" avec des virgules entre les milliers
		$tableauTemporaire = explode(',', $nombreAConvertir);// on passe les milliers dans un tableau
		for($i=0; $i<count($tableauTemporaire); $i++)// on parcourt le tableau, par milliers donc
		{
			for($j=0; $j<strlen($tableauTemporaire[$i]); $j++)// on parcourt les 3 caracteres (ou moins) du millier en cours
			{
				switch($j)
				{
					case strlen($tableauTemporaire[$i])-3://si on est dans les centaines
						if(substr($tableauTemporaire[$i], $j, 1) > 0)
						{
							if(substr($tableauTemporaire[$i], $j, 1) > 1)
								echo $tableConversionEtapeUnOuTrois[substr($tableauTemporaire[$i], $j, 1)];
							echo " cents ";
						}
						break;
					case strlen($tableauTemporaire[$i])-2:// si on est dans les dizaines
						if(substr($tableauTemporaire[$i], $j, 1) > 1)
							echo $tableConversionEtapeDeux[substr($tableauTemporaire[$i], $j, 1)];
						if(substr($tableauTemporaire[$i], $j, 1) == 1 || substr($tableauTemporaire[$i], $j, 1) == 7 || substr($tableauTemporaire[$i], $j, 1) == 9)
						break;
					case strlen($tableauTemporaire[$i])-1:// si on est dans les unites
						if(substr($tableauTemporaire[$i], $j, 1) == 1)
							echo " et ";
						if(substr($tableauTemporaire[$i], $j-1, 1) == 1 ||substr($tableauTemporaire[$i], $j-1, 1) == 7 || substr($tableauTemporaire[$i], $j-1, 1) == 9)
							if(substr($tableauTemporaire[$i], $j, 1) < 7)
								echo "-".$tableConversionDeLaDizaineQuiFaitChier[substr($tableauTemporaire[$i], $j, 1)];
							else
								echo "-".$tableConversionEtapeUnOuTrois[substr($tableauTemporaire[$i], $j, 1)];
						else
							echo "-".$tableConversionEtapeUnOuTrois[substr($tableauTemporaire[$i], $j, 1)];
						break;
				}
			}
			echo " ".$tablePuissancesDeDix[count($tableauTemporaire)-$i-1]." ";// à quelle multiple de 10^3 on est ?
		}
	}

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
