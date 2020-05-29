/*
 * Copyright (C) 2020  OopsieWoopsie
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package eu.mcdb.universal.command.api;

import java.util.concurrent.CompletableFuture;
import eu.mcdb.universal.command.UniversalCommandSender;

@FunctionalInterface
public interface AsyncCommandHandler extends CommandHandler {

    boolean handleAsync(UniversalCommandSender sender, CommandParameters parameters);

    default boolean handle(UniversalCommandSender sender, CommandParameters parameters) {
        CompletableFuture.runAsync(() -> handleAsync(sender, parameters));
        return true;
    }
}