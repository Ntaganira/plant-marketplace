package rw.ntaganira.shared.exception;

/**
 * --------------------------------------------------------------------
 * Project      : Rwanda Plant Marketplace
 * File         : BadRequestException.java
 * Author       : Heritier Ntaganira
 * Company      : NIHO TECHNOLOGIES LTD
 * Created Date : 2026-05-14
 * Description  : Exception thrown for invalid requests
 * --------------------------------------------------------------------
 */

public class BadRequestException extends RuntimeException {

    public BadRequestException(String message) {
        super(message);
    }

}