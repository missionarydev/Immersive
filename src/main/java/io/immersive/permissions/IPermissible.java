package io.immersive.permissions;

import io.immersive.utils.Tristate;

public interface IPermissible {

    /**
     * Adds a permission to the Permissible.
     * @param permission Permission to add
     */
    void addPermission(final AppliedPermission permission);

    /**
     * Removes a permission from the Permissible.
     * @param node Node to remove
     */
    void removePermission(final String node);

    /**
     * Removes a permission from the Permissible
     * @param permission Permission to remove
     */
    void removePermission(final Permission permission);

    /**
     * Removes a permission from the Permissible
     * @param permission Permission to remove
     */
    void removePermission(final AppliedPermission permission);

    /**
     * Checks if a permission is currently set.
     * @param node Node to check
     * @return Boolean if the permission is currently set.
     */
    boolean isSet(final String node);

    /**
     * Checks if a permission is currently set.
     * @param permission Permission to check
     * @return Boolean if the permission is currently set.
     */
    boolean isSet(final Permission permission);

    /**
     * Gets the value of a Permission or default if not set.
     * @param node Node to get
     * @return Permission Value or Default
     */
    Tristate getPermissionValue(final String node);

    /**
     * Gets the value of a Permission or default if not set.
     * @param permission Permission to get
     * @return Permission Value or Default
     */
    Tristate getPermissionValue(final Permission permission);

    /**
     * Checks if the Permissible has a permission.
     * @param node Node to check
     * @return
     */
    boolean hasPermission(String node);

    /**
     * Checks if the Permissible has a permission.
     * @param permission Permission to check
     * @return
     */
    boolean hasPermission(final Permission permission);

    /**
     * Clears the permissions in the Permissible
     */
    void clearPermissions();

}
