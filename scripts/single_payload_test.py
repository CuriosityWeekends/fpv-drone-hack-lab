import socket
import time

DRONE_IP = "192.168.28.1"
DRONE_PORT = 7080

payloads = [
    "cc5a01820236b7",
    "cc5a018309668080808000009974"
]

sock = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)

try:
    for payload in payloads:
        print(f"Sending: {payload}")
        sock.sendto(bytes.fromhex(payload), (DRONE_IP, DRONE_PORT))
        time.sleep(2)
except KeyboardInterrupt:
    print("Stopped.")
finally:
    sock.close()
