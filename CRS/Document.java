package CRS;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Document information of volunteers,
 * Travel of Financial Documents
 * @author Chin Ze Han
 *
 */
public class Document implements Serializable{
	public enum DocumentType {
		PASSPORT, CERTIFICATE, VISA
	}
	
	private DocumentType documentType;
	private LocalDate expiryDate;
	private String image; // filename of the image
	
	
	/**
	 * Constructor for Document
	 * @param documentType Type of document
	 * @param expiryDate Expiry date if available
	 * @param image Document image, (as file name)
	 */
	public Document(DocumentType documentType, LocalDate expiryDate, String image) {
		setDocumentType(documentType);
		setExpiryDate(expiryDate);
		setImage(image);
	}
	
	/**
	 * @return the documentType
	 */
	public DocumentType getDocumentType() {
		return documentType;
	}
	/**
	 * @param documentType the documentType to set
	 */
	public void setDocumentType(DocumentType documentType) {
		this.documentType = documentType;
	}
	/**
	 * @return the expiryDate
	 */
	public LocalDate getExpiryDate() {
		return expiryDate;
	}
	/**
	 * @param expiryDate the expiryDate to set
	 */
	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}
	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}
	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}
	
	public String toString() {
		if (getExpiryDate() != null)
			return getDocumentType() + " expired on " +
				getExpiryDate() + ", image: " + getImage();
		else
			return getDocumentType() + ", image: " + getImage(); 
	}
}
